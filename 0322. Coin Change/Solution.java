/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */

/**
 * Time Complexity: O(nm)    n is the amount and m is the number of coins
 * Space Complexity: O(n)
 */

class Solution {
    public static void main(String[] args){
        int[] arr = new int[]{186,419,83,408};
        System.out.println(coinChange(arr, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        /**
         * This is a standard Dynamic Programming Example using the memoization technique with 1-D Array.
         */
        int[] memo = new int[amount+1];
        memo[0] = 0;

        /**
         * Iterate over the amount and then iterate over the coins that are already given.
         */
        for(int i = 1; i <= amount; i++){
            memo[i] = amount+1;
            for(int coin: coins) {
                if(coin <= i)
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        }
        /** Handling the case where the amount can not be generated using the given coins. */
        if(memo[amount] > amount){
            return -1;
        }
        return memo[amount];
    }
}