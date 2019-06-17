/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public static void main(String[] args){
        int[] arr = new int[]{2,7,9,3,1};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        /**
         * Handling the edge cases of No house, One House and Two House.
         */
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0], nums[1]);
        }

        int first = 0;
        int second = 0;
        int ans = 0;

        /** The Decision of choosing the house to rob depends upon the previous two houses and maximizing the money.*/
        for(int i = 0; i < len; i++){
            ans = Math.max(first, second + nums[i]);
            second = first;
            first = ans;
        }
        return  ans;
    }
}