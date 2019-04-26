class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int top = 0, bottom = n-1, left = 0, right = n-1;
        int value = 1, cursor;

        while(top <= bottom && left <= right) {
            for (cursor = left; cursor <= right; cursor++) {
                result[top][cursor] = value++;
            }

            for (cursor = top + 1; cursor <= bottom; cursor++) {
                result[cursor][right] = value++;
            }

            if (top < bottom && left < right) {
                for (cursor = right - 1; cursor > left; cursor--) {
                    result[bottom][cursor] = value++;
                }
                for (cursor = bottom; cursor > top; cursor--) {
                    result[cursor][left] = value++;
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
