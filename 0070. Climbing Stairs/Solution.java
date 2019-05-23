//You are climbing a stair case. It takes n steps to reach to the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//Note: Given n will be a positive integer.

//Basic Fibonacci Series


/***
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */


class Solution {
    public int climbStairs(int n) {

        int step1 = 1;
        int step2 = 2;

        int temp;
        if(n == 1){
            return step1;
        }
        if(n == 2){
            return step2;
        }
        for(int i = 3; i <= n; i++){
            temp = step1 + step2;
            step1 = step2;
            step2 = temp;
        }
        return step2;
    }
}