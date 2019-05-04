class Solution {
    public int search(int[] nums, int target) {
        int low, high, mid, num;
        // bounds
        low = 0;
        high = nums.length - 1;

        while(low <= high) { // until convergence
            mid = (low+high) >>> 1;     // other way: mid = low + (high-low)/2;
            // dont do this: mid = (low + high)/2, it could overflow
            num = nums[mid];
            if(target > num) {
                low = mid + 1;
            } else if(target < num) {
                high = mid - 1;
            } else {    // hit
                return mid;
            }
        }
        return -1;
    }
}
