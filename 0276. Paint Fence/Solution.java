class Solution {
    public int numWays(int n, int k) {
        // if we have no posts or no colors to color
        if(n == 0 || k == 0) {
            return 0;
        }
        // if only 1 post, k ways to color
        if(n == 1) {
            return k;
        }

        // Dynamic Programming
        // Recurrence relation explained in pdf
        // We can reduce the relation described to multiples as shown here
        // Also we could further optimize solution to a linear time and constant space

        // Example: n = 5, k = 3
        //      p1  p2  p3  p4  p5
        //  c1  1   3   8   22  60
        //  c2  1   3   8   22  60
        //  c3  1   3   8   22  60
        //                      180 <-- total
        int[][] dp = new int[k][n];
        // n == 1
        for(int j = 0; j < k; j++) {
            dp[j][0] = 1;
        }
        // n == 2
        for(int j = 0; j < k; j++) {
            dp[j][1] = k;
        }
        // n > 2
        for(int i = 2; i < n; i++) {
            for(int j = 0; j < k; j++) {
                dp[j][i] = (k-1) * (dp[j][i-1] + dp[j][i-2]);
            }
        }
        return dp[k-1][n-1] * k;
    }
}
