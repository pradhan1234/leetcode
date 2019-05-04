class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);               // S = PAL + s
        StringBuilder rsb = (new StringBuilder(s)).reverse();  // S' = rev(S) = rev(PAL+s) = rev(s) + rev(PAL) = s' + PAL'
        sb.append("#").append(rsb);     // p = S + # + S'
        // we add the #, symbol that does not belong to alphabet set of given string to limit the length
        // eg: for s : "aaaaa", its itself a palindrome, so when we perform above steps :: aaaaa#aaaaa
        // # will help us limit the values that we compute to s.len
        int xLen = rsb.length() - computePrefixArray(String.valueOf(sb))[sb.length() - 1];
        return String.valueOf(new StringBuilder(rsb.substring(0, xLen)).append(s));
    }

    // Implementation directly from KMP's compute pi array
    // Examples of Prefix Arrays
    // abcdabcd             :: 0 0 0 0 1 2 3 4
    // abcdabcddcbadabc     :: 0 0 0 0 1 2 3 4 0 0 0 1 0 1 2 3
    // acacabacacabacacac   :: 0 0 1 2 3 0 1 2 3 4 5 6 7 8 9 10 11 4
    private static int[] computePrefixArray(String pattern) {
        int[] prefixArray = new int[pattern.length()];
        int i, j;

        // Consider:
        //     index    0   1   2   3   4   5   6
        //   pattern    a   b   a   d   a   b   b
        // prefixArr    0   0   1   0   1   2   0
        //
        // The value in prefixArray indicates, what is the longest proper suffix that is also a prefix of the pattern
        // which is always 0 for index 0
        // we then start by i = 1 and j = 0
        // we reduce j until it reaches 0 or pattern[j] == pattern[i]
        // if it matches, prefixArray[i] = j + 1
        // if j == 0, set prefixArray[i] to 0

        prefixArray[0] = 0;
        j = 0;
        i = 1;

        while(i<pattern.length()){
            while(j>0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = prefixArray[j-1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)) {
                prefixArray[i] = j + 1;
                j++;
            }
            if(j==0) {
                prefixArray[i] = 0;
            }
            i++;
        }
        return prefixArray;
    }
}