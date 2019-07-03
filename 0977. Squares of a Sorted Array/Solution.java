/**
 * Time Complexity: O(n)    n is the size of given Array
 * Space Complexity: O(n)
 */

class Solution {
    public int[] sortedSquares(int[] A) {

        int N = A.length;
        int firstNegative = 0;

        //Find the start of Negative number in the entire Array.
        while(firstNegative < N && A[firstNegative] < 0 )
            firstNegative++;

        int i = firstNegative-1;
        int j = firstNegative;
        int[] result = new int[N];
        int k = 0;

        //Use the two Pointer approach from the point where the negative numbers starts and the positive number starts.
        //Check for Absolute value and whichever is the smallest we will do the square and insert in the result
        while( i >= 0 && j < N ){
            if( Math.abs(A[i]) < Math.abs(A[j])){
                result[k] = A[i] * A[i];
                k++;
                i--;
                continue;
            }
            result[k] = A[j] * A[j];
            k++;
            j++;
        }

        //Check for the remaining elements that were left out as per the previous While Condition
        while( i >= 0 ){
            result[k] = A[i] * A[i];
            k++;
            i--;
        }

        while( j < N ){
            result[k] = A[j] * A[j];
            k++;
            j++;
        }

        return result;
    }
}