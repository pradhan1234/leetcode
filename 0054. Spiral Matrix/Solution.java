/***
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

class Solution {
    public List <Integer> spiralOrder(int[][] matrix) {
        List result = new LinkedList();

        if (matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        int cursor = 0;

        while (top <= bottom && left <= right) {

            for (cursor = left; cursor <= right; cursor++) {
                result.add(matrix[top][cursor]);
            }

            for (cursor = top + 1; cursor <= bottom; cursor++) {
                result.add(matrix[cursor][right]);
            }

            if (top < bottom && left < right) {
                for (cursor = right - 1; cursor > left; cursor--) {
                    result.add(matrix[bottom][cursor]);
                }
                for (cursor = bottom; cursor > top; cursor--) {
                    result.add(matrix[cursor][left]);
                }
            }

            top++;
            bottom--;
            left++;
            right--;
        }
        return result;
    }
}
