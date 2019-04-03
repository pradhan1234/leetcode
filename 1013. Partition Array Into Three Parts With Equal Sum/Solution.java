class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = computeSum(A);
        
        // total sum should be divisible by 3
        if(sum%3 != 0) {
            return false;
        }
                
        // each partition should equal S/3
        int sum1, sum2, sum3;
        sum1 = sum/3;
        sum2 = sum/3;
        
        
        boolean flag1 = false, flag2 = false;
        int currentSum = 0;
        
        for(int i = 0; i < A.length; i++) {
            currentSum += A[i];
            
            if(flag1 == false && currentSum == sum1) {
                flag1 = true;
            } else if(flag1 == true && flag2 == false && currentSum == sum1+sum2) {
                flag2 = true;
                break;
            }
        }
        return flag1 & flag2;
    }
    
    private int computeSum(int[] A) {
        int sum = 0;
        
        for(int a: A) {
            sum += a;
        }
        
        return sum;
    }
}