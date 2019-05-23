class Solution {

    private static int flipDirection(int direction) {
        return 1 - direction;
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        // if null or empty, return empty array
        if(matrix == null || matrix.length == 0) {
            return new int[0];
        }

        int mRows, nCols;
        mRows = matrix.length;
        nCols = matrix[0].length;

        int[] result = new int[mRows*nCols];
        int x = 0, y = 0; //current coordinates for traversing in matrix
        int direction = 0; // 0: top right, 1: bottom left

        // used for moving left, right, down and top
        int[][] delta = {{-1, 1}, {1, -1}};

        for(int i = 0; i<mRows*nCols; i++) {
            // store current
            result[i] = matrix[x][y];

            // update x and y
            x += delta[direction][0];
            y += delta[direction][1];

            // handle cases where we hit edges

            if (x >= mRows) {
                x = mRows - 1;
                y += 2;
                direction = flipDirection(direction);
            }

            if (y >= nCols) {
                y = nCols - 1;
                x += 2;
                direction = flipDirection(direction);
            }

            if (x < 0)  {
                x = 0;
                direction = flipDirection(direction);
            }

            if (y < 0)  {
                y = 0;
                direction = flipDirection(direction);
            }
        }

        return result;
    }
}
