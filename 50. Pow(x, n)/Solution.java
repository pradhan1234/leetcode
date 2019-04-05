class Solution {
    
    public double myPow(double x, int n) {
        // call helper method
        return myPow(x, (long) n);
    }
    
    // helper method
    private double myPow(double x, long n) {
        // case: n = 0
        if(n == 0) {
            return 1;
        }
        // case: n = 1
        if(n == 1) {
            return x;
        }
        // case: n < 0, find nth power of reciprocal of x
        // changing type of n to long takes care of cases like when n == Integer.MIN_VALUE
        // otherwise when sign flips we run into overflow 
        if(n < 0) {
            x = 1/x;
            n = -1 * n;
        }
        
        // using divide and conquer technique
        // find x^2 to power n/2
        // time complexity O(log n)
        double p = myPow(x*x, n/2);
        // if n is even, we have result
        if(n%2 == 0) {
            return p;
        } else { // multiply it with x
            return p * x;
        }
    }
}
