class DisjointSet {
    private int[] rep;
    private int[] rank;
    int components;

    DisjointSet(int size) {
        makeSet(size);
    }

    // init each entry/point/node with rank 0 and rep as itself
    private void makeSet(int size) {
        rep = new int[size];
        rank = new int[size];
        for(int i = 0; i< size; i++) {
            rep[i] = i;
        }
        components = size; // tracks number of components
    }

    // find also performs path compression
    // this is the crux that makes union-find so efficient
    private int find(int x) {
        if(rep[x] != x) {
            rep[x] = find(rep[x]);
        }
        return rep[x];
    }

    // union x and y
    // return true is union was actually performed
    // false if both already in the same set
    boolean union(int x, int y) {
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
        components--;
        return true;
    }
}

public class ConnectedComponentDirectedGraph {

    private static int countComponents(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        for(int[] e: edges) {
            ds.union(e[0], e[1]);
        }
        return ds.components;
    }

    public static void main(String[] args) {
        int n;
        int[][] edges;

        n = 5;
        edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        System.out.println("output 1: " + countComponents(n ,edges));

        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        System.out.println("output 2: " + countComponents(n ,edges));


    }
}
