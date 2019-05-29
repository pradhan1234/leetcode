/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */


/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        /** Base Case when nums is null*/
        if(nums.length == 0){
            return -1;
        }

        while(start <= end){
            /** Get the Mid Value of Start and End of the search area.*/
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            /**
             * There are in general 2 conditions where the mid value can be greater than the initial value or less than the initial value.
             * Further demending upon each of these cases we can identify the further criteria for searching the target.
             */
            if(nums[start] <= nums[mid]){
                /**
                 * If Target is less than the mid value and target is greater than the Start value
                 * we consider the first half of the array and change the end position.
                 * Else we can look for the second half and change the start position.
                 */
                if( target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            else{
                /**
                 * If Target is greater than the mid value and target is less than the end value
                 * we consider the second half of the array and change the start position.
                 * Else we can look for the first half and change the end position.
                 */
                if( target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        /** If the while loop doesn't return anything that means that the element was not found and the algorithm should return -1 */
        return -1;
    }
}