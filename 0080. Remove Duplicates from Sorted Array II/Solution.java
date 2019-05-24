/** Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory. */


/***
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */



class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;

        /** Checking for base cases i.e. if the array is empty or not. */
        if(len == 0){
            return 0;
        }

        /** Keeping the track of currentNumber that is being analyzed and the count of that number */
        int currentNo = nums[0];
        int currentCount = 0;

        for(int i = 0 ; i < len; i++){
            if(nums[i] == currentNo && currentCount < 2){
                /** Keeping a count of the currentNo being analyzed. */
                currentCount++;
            }
            else if(nums[i] == currentNo && currentCount >= 2){
                /** Makes appropriate call and change the traversal critera as the element is replaced by a new element and that is yet to be traversed.
                 * Also we do not need to traverse the whole array as the elements are shifted so we also decrease the len by 1. */
                nums = removeElement(nums, i);
                i--;
                len--;
            }
            else if(nums[i] != currentNo){
                /** if a new nymber is encountered then we need to change the number as well as the value of counter */
                currentNo = nums[i];
                currentCount = 1;
            }
        }
        return len;
    }

    /** Getting the elements from the back to the front as the index specified has a number that is repeated more than 2 times so it is not necessary.
     * We also do not need the number itself, because we can ignore the elements occuring after the returned length in the main function.*/
    public int[] removeElement(int[] nums, int index){
        for(int i = index; i < nums.length - 1; i++){
            nums[i] = nums[i+1];
        }
        return nums;
    }

}