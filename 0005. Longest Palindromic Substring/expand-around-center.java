// Time Complexity : O(n^2)
// Space Complexity : O(1)
class Solution {
    public String longestPalindrome(String s) {
        // base cases
        if(s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0; // to store indices of longest palindromic substring
        int len1, len2, len;
        
        // we want to find a good center, but we dont know which
        // so we try over the length of string
        for(int i = 0; i<s.length(); i++) {
            len1 = expandAroundCenter(s, i, i);   // odd length
            len2 = expandAroundCenter(s, i, i+1); // even length
            len = Math.max(len1, len2); // choose only the best
            if(len > end - start) {
                start = len%2 == 0 ? i - (len/2) + 1 : i - len/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    // we have a virtual center point for palindrome to expand around
    // the goal here is to find such center that can generate max length palindromic substring for given s
    // In each iteration, this function is called twice
    // with left == right for palindrome with odd length, where we have a single letter as center eg: abcba :: c is center
    // with right = lef + 1, even length, 2 letters as center, ed: abccba :: cc are centers
    // time complexity of function is linear, and constant extra space
    private int expandAroundCenter(String s, int left, int right) {
        int i = left, j = right;
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        // when while terminates, i and j are one too left and one too right respectively
        return (j-1) - (i+1) + 1;
    }
}