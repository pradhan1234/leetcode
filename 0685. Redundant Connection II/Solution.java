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
