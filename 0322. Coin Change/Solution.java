
class Solution {
    public static void main(String[] args){
        int[] arr = new int[]{186,419,83,408};
        System.out.println(coinChange(arr, 6249));
    }

    public static int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount+1];
        memo[0] = 0;

        for(int i = 1; i <= amount; i++){
            memo[i] = amount+1;
            for(int coin: coins) {
                if(coin <= i)
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
            }
        }
        if(memo[amount] > amount){
            return -1;
        }
        return memo[amount];
    }
}