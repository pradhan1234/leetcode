class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums==null){
            return 0;
        }

        int cursorIndex = 0, nextIndex = 0;

        while(cursorIndex<nums.length && nextIndex<nums.length) {
            nums[cursorIndex] = nums[nextIndex];
            cursorIndex++;
            nextIndex++;
            while(nextIndex<nums.length && nums[nextIndex]==nums[nextIndex-1]) {
                nextIndex++;
            }
        }

        return cursorIndex;
    }
}