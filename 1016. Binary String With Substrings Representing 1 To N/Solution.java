class Solution {
    public boolean queryString(String S, int N) {
        int n = 1;
        while(n <= N) {
            if(S.contains(Integer.toBinaryString(n))){
                n++;
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
}