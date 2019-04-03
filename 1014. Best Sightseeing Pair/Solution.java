class Solution {
    public int maxScoreSightseeingPair(int[] A) {

        int runningBest = A[0];     // stores best until now value for a[i] + i 
        int optimum = 0;
        
        for(int j = 1; j<A.length; j++) {
            optimum = Math.max(optimum, runningBest + A[j] - j);
            runningBest = Math.max(runningBest, A[j] + j);      // update a[i] + i
        }
        
        return optimum;
    }
}