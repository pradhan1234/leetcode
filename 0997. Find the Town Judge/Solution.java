/***
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 */

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
