/**
 * Time Complexity: O(m + n)    m and n are the sizes of two array
 * Space Complexity: O(1)       Operation is performed in the same array i.e. nums1
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Start from the end, looking for filling the array in reverse order.
        while(m > 0 && n > 0){
            if(nums1[m-1] > nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }

        //Need to check for the Second array only because the first array would already be in place!
        while(n > 0){
            nums1[m+n-1] = nums2[n-1];
            n--;
        }

    }
}
