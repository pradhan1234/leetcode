/***
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 * In worst case, there could be as many as k indices in our deque
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;

        // base cases
        // n == 0
        if(n==0){
            return new int[0];
        }
        // k = 1 :: each element by itself in window
        if(k==1) {
            return nums;
        }

        // we'll use a deque, store index to represent the elements of array
        // we would store at a given time, only the indices that are imnportant to us
        // before adding to the end of deque, we'll remove indices those correspond to elements
        // that are less than current element
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[n-k+1];

        // initial step: parse the first window of size k
        for(int i = 0; i < k; i++) {
            // remove indices corresponding to elements that are less than current element
            while(list.size() > 0 && nums[list.getLast()] < nums[i]) {
                list.removeLast();
            }
            list.addLast(i);
        }

        // loop invariant: We would have the list always in reverse sorted order of elements
        // that the indices represent, and the first index corresponds to highest element of
        // the current window
        result[0] = nums[list.getFirst()];

        for(int i = k; i < n; i++) {
            // remove indices from head of deque if they no longer belong to the window
            // before of the unit increment  we have here, we only need to check this for the head
            if(list.size()>0 && list.getFirst() == i - k) {
                list.removeFirst();
            }
            // remove indices corresponding to elements that are less than current element
            while(list.size() > 0 && nums[list.getLast()] < nums[i]) {
                list.removeLast();
            }
            list.addLast(i);
            result[i - k + 1] = nums[list.getFirst()];
        }
        return result;
    }
}
