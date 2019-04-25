/***
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 *
 * Below is one possible representation of s1 = "great":
 *
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 *
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 *
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 *
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 *
 * Example 1:
 *
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 */

class Solution {
    public boolean isScramble(String s1, String s2) {
        // base case: len(s1) == len(s2)
        if(s1.length() != s2.length()) {
            return false;
        }
        // base case: s1 == s2
        if(s1.equals(s2)) {
            return true;
        }

        // quick check: #letters should match
        // inc for c in s1, dec for s2, check for completeness
        int[] letters = new int[26];
        int i;
        for(i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for(i = 0; i < 26; i++) {
            if(letters[i] != 0) {
                return false;
            }
        }

        // s1[0..i] is scramble of s2[0..i] and s1[i+1...n-1] is scramble of s2[i+1..n-1]
        // s1[0..i] is scramble of s2[n-i..n-1] and s1[i+1..n-1] is scramble of s2[0..n-i-1]
        for(i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0, i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if(isScramble(s1.substring(0,i), s2.substring(s1.length()-i)) && isScramble(s1.substring(i), s2.substring(0,s1.length()-i))) {
                return true;
            }
        }

        return false;
    }
}