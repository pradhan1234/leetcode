/**
 * We have a collection of rocks, each rock has a positive integer weight.
 *
 * Each turn, we choose the two heaviest rocks and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 */

/**
 * Time Complexity: O( n*log(n) )
 * Space Complexity: O(n)
 */


class Solution {
    public int lastStoneWeight(int[] stones) {
        /**
         * Priority Queue is used and the order is reversed so that we can reduce the number of operations performed.
         * Without reversing the order time complexity of the alrorithm would increase significantly.
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s: stones){
            pq.add(s);
        }
        /**
         * Until the Queue is empty we remove the element with highest priority from the priority queue,
         * and also check if the next element is null or not.
         * If the next element after the poll is null then the element recently removed is the last element and we can just return that.
         * Else we poll another element and add the subtraction of that to the priority queue again.
         */
        while(!pq.isEmpty()){
            int largest = pq.poll();
            if(pq.peek() == null){
                return largest;
            }
            pq.add(largest - pq.poll());
        }
        return 0;
    }
}