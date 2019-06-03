class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while(i <= j){
            int mid = i + (j-i)/2;
            if (nums[mid] == target){
                return mid;
            }
            if(target > nums[mid] && mid + 1 == nums.length){
                return nums.length;
            }
            else if(target > nums[mid] && target < nums[mid+1]){
                return mid + 1;
            }
            if (target < nums[mid] && mid - 1 == -1){
                return 0;
            }
            else if(target < nums[mid] && target > nums[mid-1]){
                return mid;
            }
            if(nums[mid] > target){
                j = mid-1;
            }
            else{
                i = mid + 1;
            }
        }
        return i;
    }
}