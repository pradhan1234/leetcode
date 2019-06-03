class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        if(len == 0) return 0;

        while(len > 0 && s.charAt(len - 1)==' '){
            len--;
        }
        int i = len - 1;
        while(i >= 0 && s.charAt(i)!=' '){
            i--;
        }
        return len - i - 1 ;
    }
}