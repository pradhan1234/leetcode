/***
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */

class Solution {
    public boolean canJump(int[] nums) {
        // we'll try reverse engineering, can we reach to index 0 from index n-1.
        int cursor = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            // if standing at index i, with max jump nums[i] can we go past cursor?
            if (i + nums[i] >= cursor) {
                cursor = i;
            }
        }
        return cursor == 0;
    }
}
