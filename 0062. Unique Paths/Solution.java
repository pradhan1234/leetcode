class Solution {
    public int uniquePaths(int nCol, int nRow) {

        int[][] dp = new int[nRow][nCol];
        // base case
        for(int x = 0; x < nCol; x++) {
            dp[0][x] = 1;
        }
        for(int y = 0; y < nRow; y++) {
            dp[y][0] = 1;
        }

        // Recurence Relation:
        // Number of ways to reach cell(y, x)
        // N(y, x) = N(y-1, x) + N(y, x-1)
        for(int y = 1; y < nRow; y++) {
            for(int x = 1; x < nCol; x++) {
                dp[y][x] = dp[y-1][x] + dp[y][x-1];
            }
        }
        return dp[nRow-1][nCol-1];
    }
}