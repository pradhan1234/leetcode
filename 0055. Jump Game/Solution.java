class Solution {
    public boolean canJump(int[] nums) {
        // start from last index, can we reach to index 0 from index n-1.
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
