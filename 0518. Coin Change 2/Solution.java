/**
 * 0518. Coin Change 2
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 */


/**
 * Time Complexity: O(mn)   m is the number of coins and n is the amount
 * Space Complexity: O(n)
 */

class Solution {
    public static void main(String[] args){
        int[] arr = new int[]{1,2,5};
        System.out.println("Answer: "+change(5, arr));
    }

    public static int change(int amount, int[] coins) {
        /**
         * Memoization Data Structure used is an 1-D array that willbe used to store the previous states
         *
         */
        int[] answer = new int[amount + 1];
        answer[0] = 1;
        /**
         * Iterate over the coins that are already given and
         * then look at the left over amount for the number of ways that can be obtained
         * which is already mentioned in the Memoization table.
         */
        for(int coin : coins){
            for(int i=1; i<=amount; i++){
                if(coin <= i)
                    answer[i] += answer[i - coin];
            }
        }
        return answer[amount];
    }
}