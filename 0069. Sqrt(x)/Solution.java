/***
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
