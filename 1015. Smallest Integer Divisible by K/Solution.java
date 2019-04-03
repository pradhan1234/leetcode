class Solution {
    public int smallestRepunitDivByK(int K) {
        int n = 1;
        int len = 1;
    
        while(len <= K) {
            if (n % K == 0) {
                return len;
            }
            n = (n * 10 + 1) % K;
            len++;
        }
        return -1;
    }
}