class Solution {
    public int findJudge(int N, int[][] trust) {

        // array to hold indegree and outdegree of each node
        int[] indegree = new int[N];
        int[] outdegree = new int[N];

        // populate these values
        // [a, b] can be visualized as a ---> b i.e. a trusts b
        // a.outdegree++, b.indegree++
        for(int[] edge: trust){
            outdegree[edge[0]-1] += 1;
            indegree[edge[1]-1] += 1;
        }

        // find such node that has outdegree 0 and indegree N - 1
        // judge trusts no one, but everyone except the judge trusts the judge
        for(int i = 0; i < N; i++) {
            if(outdegree[i] == 0 && indegree[i] == N-1){
                return i+1;
            }
        }
        return -1;
    }
}
