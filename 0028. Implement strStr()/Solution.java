// KMP Algorithm
// Time Complexity : O(m+n) Amortized

class Solution {
    public int strStr(String haystack, String needle) {

        // base cases
        if(needle.length() == 0) {
            return 0;
        }

        if(needle.length()>haystack.length()){
            return -1;
        }

        int[] prefixArray = computePrefixArray(needle);
        return matchPattern(haystack, needle, prefixArray);
    }

    // Pattern matching using KMP Algorithm
    // Structure is very much similar to the compute prefix function
    // Refer that first
    private static int matchPattern(String s, String pattern, int[] prefixArray) {
        int i = 0, j = 0;
        // we reduce j until it reached zero or s[i] == pattern[j]
        // the above step is equivalent of performing shift
        // if its a match we increment j
        // if pattern has matched entirely, return index
        while(i<s.length()) {
            while(j>0 && s.charAt(i) != pattern.charAt(j)) {
                j = prefixArray[j-1];
            }
            if(s.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if(j==pattern.length()) {
                return i - (pattern.length()-1);
            }
            i++;
        }
        return -1;
    }

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