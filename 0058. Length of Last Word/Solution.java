/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        if(len == 0) return 0;

        /** Reduce extra spaces from the end of the String. */
        while(len > 0 && s.charAt(len - 1)==' '){
            len--;
        }
        int i = len - 1;

        /** Start counting the final length of the word. */
        while(i >= 0 && s.charAt(i)!=' '){
            i--;
        }
        return len - i - 1 ;
    }
}
