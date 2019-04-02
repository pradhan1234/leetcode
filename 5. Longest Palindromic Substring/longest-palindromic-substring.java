// O(n^2) Space and O(n^2) Time

class Solution {

    private static void printMatrix(boolean[][] mat, int n){
         for(int i = 0; i<n; i++){
             for(int j = 0; j<n; j++){
                 if(i<=j){
                    System.out.print(mat[i][j]+" ");
                 }
                 else{
                     System.out.print("**** ");
                 }
             }
             System.out.print("\n");
         }
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==0){
            return s;
        }
        boolean[][] table = new boolean[n][n];
                
        // Base Case: len = 1
        for(int i = 0; i<n; i++){
            table[i][i] = true;
        }
        
        int maxLength = 1;
        int bestI=0, bestJ=0;
        for(int i = 0; i<n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                table[i][i+1] = true;
                
                if(maxLength < 2){
                    maxLength = 2;
                    bestI = i;
                    bestJ = i+1;
                }
            }
        }
        
        int j;
        for(int k = 3; k<=n; k++){
            for(int i = 0; i<n-k+1; i++){
                j = i+k-1;
                // System.out.println("k: "+k+" i: "+i+" j: "+j);
                if(table[i+1][j-1] && (s.charAt(i) == s.charAt(j))){
                    table[i][j] = true;
                    if(maxLength < k){
                        maxLength = k;
                        bestI = i;
                        bestJ = j;
                    }
                }
            }
        }
        
        // printMatrix(table, n);
        // System.out.println("Max Length:" + maxLength);
        return s.substring(bestI, bestJ+1);
        
    }
}
