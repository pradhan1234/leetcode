/***
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other
 * nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
 *
 * The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N),
 * with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an
 * edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed
 * edge connecting nodes u and v, where u is a parent of child v.
 *
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers,
 * return the answer that occurs last in the given 2D-array.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given directed graph will be like this:
 *   1
 *  / \
 * v   v
 * 2-->3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * Output: [4,1]
 * Explanation: The given directed graph will be like this:
 * 5 <- 1 -> 2
 *      ^    |
 *      |    v
 *      4 <- 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */

class DisjointSet {
    int[] rep;
    int[] rank;

    DisjointSet(int size) {
        makeSet(size);
    }

    private void makeSet(int size) {
        rep = new int[size];
        rank = new int[size];
        for(int i = 0; i< size; i++) {
            rep[i] = i;
        }
    }

    public int find(int x) {
        if(x != rep[x]) {
            rep[x] = find(rep[x]);
        }
        return rep[x];
    }

    public boolean union(int x, int y) {
        int repX = find(x), repY = find(y);
        if(repX == repY) {
            // already in same set
            return false;
        } else if (rank[repX] < rank[repY]) {
            rep[repX] = repY;
        } else if (rank[repY] < rank[repX]) {
            rep[repY] = repX;
        } else {
            rep[repY] = repX;
            rank[repX]++;
        }
        return true;
    }
}

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length+1);
        int[] parent = new int[edges.length+1];
        // find if any node with 2 parents
        int indexSecondParent = -1;
        int i, u, v;
        for(i = 0; i < edges.length; i++) {
            u = edges[i][0];
            v = edges[i][1];
            if(parent[v] != 0) {
                indexSecondParent = i;
            } else {
                parent[v] = u;

            }
        }

        // find edge that creates a cycle
        int indexCycle = -1;
        for(i = 0; i < edges.length; i++){
            if(i == indexSecondParent) {
                continue;
            }
            if(!ds.union(edges[i][0], edges[i][1])) {
                indexCycle = i;
                break;
            }
        }

        if(indexSecondParent == -1) {
            return edges[indexCycle];
        }

        if(indexCycle != -1) {
            return new int[]{parent[edges[indexSecondParent][1]], edges[indexSecondParent][1]};
        }

        return edges[indexSecondParent];
    }

}
