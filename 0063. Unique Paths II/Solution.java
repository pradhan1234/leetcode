class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int nRow = grid.length, nCol = grid[0].length;
        // If obstacle at 0, 0 no way to reach goal
        if(grid[0][0] == 1) {
            return 0;
        }
        int dp[][] = new int[nRow][nCol];
        dp[0][0] = 1;   // basis
        // base cases
        // we can reach to 0, x iff its clear and we could reach to 0, x - 1
        for(int x = 1; x < nCol; x++) {
            if(dp[0][x-1] == 1 && grid[0][x] == 0) {
                dp[0][x] = 1;
            }
        }
        // same argument as above
        for(int y = 1; y < nRow; y++) {
            if(dp[y-1][0] == 1 && grid[y][0] == 0) {
                dp[y][0] = 1;
            }
        }

        // Recurrence Relation
        // N(y, x)  = 0; if grid(y, x) == 1
        //          = N(y-1, x) + N(y, x-1); otherwise
        for(int y = 1; y < nRow; y++) {
            for(int x = 1; x < nCol; x++) {
                if(grid[y][x] == 0) {
                    dp[y][x] = dp[y-1][x] + dp[y][x-1];
                }
            }
        }
        return dp[nRow-1][nCol-1];
    }
}