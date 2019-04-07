class DisjointSet {
    int[] rep;
    int[] rank;
    
    DisjointSet(int size) {
        makeset(size);
    }
    
    // init each entry/point/node with rank 0 and rep as itself
    private void makeset(int size) {
        rep = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++) {
            rep[i] = i;
        }
    }
    
    // union x and y
    // return true is union was actually performed
    // false if both already in the same set
    public boolean union(int x, int y) {
        int repX, repY;
        repX = find(x);
        repY = find(y);
        
        if(repX == repY) {
            return false;
        } else {
            if(rank[x] < rank[y]) {
                rep[repX] = repY;
            } else if(rank[y] < rank[x]) {
                rep[repY] = repX;
            } else {
                rep[repX] = repY;
                rank[repY]++;
            }
        }
        return true;
    }
    
    // find also performs path compression
    // this is the crux that makes union-find so efficient
    public int find(int x) {
        if(rep[x] != x) {
            rep[x] = find(rep[x]);
        }
        return rep[x];
    }
    
    public void print() {
        for(int i = 0; i < rep.length; i++) {
            System.out.println(rank[i] + ", " +rep[i]);
        }
    }
    
}

class Solution {
    public void solve(char[][] board) {
        // base case checks
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int rows = board.length, cols = board[0].length;
        // +1 for dummy boundary of zeros
        DisjointSet ds = new DisjointSet(rows*cols + 1);
        
        // ds.print();
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    // check if on edge
                    if(i==0 || j ==0 || i == rows-1 || j == cols-1) {
                        ds.union(i*cols + j, rows*cols);
                    } else {
                        if(i-1>=0 && board[i-1][j] == 'O') {
                            ds.union(i*cols+j, (i-1)*cols + j);
                        }
                        if(j+1<=cols && board[i][j+1] == 'O') {
                            ds.union(i*cols+j, i*cols + j+1);
                        }
                        if(i+1<=rows && board[i+1][j] == 'O') {
                            ds.union(i*cols+j, (i+1)*cols + j);
                        }
                        if(j-1>=0 && board[i][j-1] == 'O') {
                            ds.union(i*cols+j, i*cols + j-1);
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O' && ds.find(i*cols+j) != ds.find(rows*cols)) {
                        board[i][j] = 'X';
                }
            }
        }
    }
}