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
