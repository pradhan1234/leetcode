/***
 * @author yashpradhan
 * Union Find Algorithm
 */
class DisjointSet {
    int[] rep;
    int[] rank;
    private int count;

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
        count = size;
    }

    // find also performs path compression
    // this is the crux that makes union-find so efficient
    public int find(int x) {
        if(rep[x] != x) {
            rep[x] = find(rep[x]);
        }
        return rep[x];
    }

    // union x and y
    // return true is union was actually performed
    // false if both already in the same set
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
        count--;
        return true;
    }

    public int getCount(){
        return count;
    }

    public void print(){
        int count = 0;
        for(int e: rep) {
            if(count%5 ==0){
                System.out.println();
            }
            System.out.print(e +" ");
            count++;
        }
    }
}

public class NumberIsland {

    public static void main(String[] args) {
        char[][] grid;

        grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'} };
        System.out.println("case 1: " + numIslands(grid));

        grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println("case 2: " + numIslands(grid));


    }

    public static int numIslands(char[][] grid) {
        // base cases
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int nRow, nCol;
        nRow = grid.length;
        nCol = grid[0].length;
        int countZero = 0;
        DisjointSet ds = new DisjointSet(nRow*nCol);

        for(int r = 0; r < nRow; r++) {
            for(int c = 0; c < nCol; c++) {
                // 0: ignore
                if(grid[r][c] == '0'){
                    countZero++;
                    continue;
                }
                // 1: mark visited and try doing union with 4 connected neighbours
                if (r - 1 >= 0 && grid[r-1][c] == '1') {
                    ds.union(r * nCol + c, (r-1) * nCol + c);
                }
                if (c - 1 >= 0 && grid[r][c-1] == '1') {
                    ds.union(r * nCol + c, r * nCol + c - 1);
                }
                if (r + 1 < nRow && grid[r+1][c] == '1') {
                    ds.union(r * nCol + c, (r+1) * nCol + c);
                }
                if (c + 1 < nCol && grid[r][c+1] == '1') {
                    ds.union(r * nCol + c, r * nCol + c + 1);
                }
            }
        }
        return ds.getCount() - countZero;
    }
}
