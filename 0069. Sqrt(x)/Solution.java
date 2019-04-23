/***
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 *
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 * Solved using binary search approach, truncate search space until we find our answer
 */

class Solution {
    public int mySqrt(int x) {
        // taking care of overflow is very critical
        int low = 1, high = x, mid = (int)(low*0.5 + high*0.5), p;

        while(low<mid && mid<high) {
            // we could check mid^2 == x, but chances are it could also overflow
            if(mid == x/mid) {
                return mid;
            }

            if(mid > x/mid) {
                high = mid;
            } else {
                low = mid;
            }
            // again take care of overflow
            mid = (int)(low*0.5 + high*0.5);
        }
        return mid;
    }
}
