/**
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 */

class Solution {
    public int longestPalindrome(String s) {
        // Intuition:
        // consume all letter occuring even number of times for constructing palindrome
        // if there are letters occuring odd number of time, we can use all but one of these too
        // at end the letters that are left alone, we use one of it
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                count += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        if(set.isEmpty()) {
            return count;
        }
        return ++count;
    }
}
