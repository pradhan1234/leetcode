/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 */


/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */


class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        /**
         * Standard Example of Binary Search with handling the edge cases.
         */
        while(i <= j){
            int mid = i + (j-i)/2;
            /** If the target is found the return the index*/
            if (nums[mid] == target){
                return mid;
            }

            /** If the terget is to be inserted at the end of the array or
             * Target is greater than mid and less than mid + 1 */
            if(target > nums[mid] && mid + 1 == nums.length){
                return nums.length;
            }
            else if(target > nums[mid] && target < nums[mid+1]){
                return mid + 1;
            }

            /** If the terget is to be inserted at the begining of the array or
             * Target is less than mid and greater than mid - 1 */
            if (target < nums[mid] && mid - 1 == -1){
                return 0;
            }
            else if(target < nums[mid] && target > nums[mid-1]){
                return mid;
            }

            /** Reducing the Search to half based on the value of mid with respect of Target.*/
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