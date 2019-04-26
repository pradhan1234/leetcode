class Solution {
    public int strStr(String haystack, String needle) {
        // TODO: handle base cases, implement matchPattern
        
        // abcdabcd             :: 0 0 0 0 1 2 3 4        
        // abcdabcddcbadabc     :: 0 0 0 0 1 2 3 4 0 0 0 1 0 1 2 3
        // acacabacacabacacac   :: 0 0 1 2 3 0 1 2 3 4 5 6 7 8 9 10 11 4
        
        int[] prefixArray = computePrefixArray("abcdabcd");
        return matchPattern(haystack, needle, prefixArray);
    }
    
    private static int matchPattern(String s, String pattern, int[] prefixArray) {
        // TODO: Implement this
        return 0;
    }
    
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
        // if pattern[i] == pattern[j] then prefixArray[i] = j + 1
        // else j = prefixArray[j-1] until we don't match, unless j is 0 then prefixArray[i] = 0
        
        prefixArray[0] = 0;
        j = 0;
        i = 1;
        
        while(i<pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(j)) {
                prefixArray[i] = j + 1;
                i++;
                j++;
            } else {
                while(j>0 && pattern.charAt(j) != pattern.charAt(i)) {
                    j = prefixArray[j-1];
                }
                if(j==0) {
                    prefixArray[i] = 0;
                    i++;
                }
            }
        }
        
        // for(int v : prefixArray) {
        //     System.out.print(" " + v);
        // }
        
        return prefixArray;
        
    }
}
