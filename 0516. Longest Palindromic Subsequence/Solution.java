// Solution using Dynamic Programming

class Solution {
    public int longestPalindromeSubseq(String s) {

        // Recurrence is a bit tricky but not too complicated.
        // base case:
        // len = 1, length of LPS = 1
        // len = 2, length of LPS = 2 iff both characters are same, otherwise 1
        //
        // Remember how palindromes expand around the center, so here we apply the same logic
        //      X + LPS(sub-problem) + X; matching characters means increase in length by 2
        //
        // general case:
        // s[i...j], length > 2, LPS[i][j] = 2 + LPS[i+1][j-1] iff s[i] == s[j] otherwise max(LPS[i+1][j], LPS[i][j-1])
        //
        //  Example: See how only upper diagonal matrix is populated
        //
        //          0   1   2   3   4
        //          b   b   b   a   b
        //  0   b   1   2   3   3   4
        //  1   b       1   2   2   3
        //  2   b           1   1   3
        //  3   a               1   1
        //  4   b                   1

        int n = s.length();

        if(n == 0) {
            return 0;
        }

        int[][] LPS = new int[s.length()][s.length()];
        int i, j, k;

        // LPS of length 1
        for(i = 0; i < n; i++) {
            LPS[i][i] = 1;
        }

        // LPS of length 2
        for(i = 0; i < n - 1; i++) {
            LPS[i][i+1] = (s.charAt(i) == s.charAt(i+1) ? 2 : 1);
        }

        // LPS of length > 2
        for(k = 3; k <= n; k++) {   // k indicates length of current window
            for(i = 0; i < n - k + 1; i++) {    // i indicates start index
                j = i + k - 1;  // j indicates windows of length k starting at index i
                LPS[i][j] = (s.charAt(i) == s.charAt(j) ? LPS[i+1][j-1] + 2 : Math.max(LPS[i+1][j], LPS[i][j-1]));
            }
        }
        return LPS[0][n-1];
    }
}