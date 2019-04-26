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