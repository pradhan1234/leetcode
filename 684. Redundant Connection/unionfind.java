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
        if(rep[x] != x) {
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
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(1001);
        for(int[] edge : edges) {
            //print(""+ edge[0] + "," + edge[1]);
            if(!ds.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[]{};
    }
    
    private void print(String msg) {
        System.out.println("LOG: " + msg);
    }
}