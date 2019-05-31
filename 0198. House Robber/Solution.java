class Solution {
    public static void main(String[] args){
        int[] arr = new int[]{2,7,9,3,1};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return nums[0];
        }
        if(len == 2){
            return Math.max(nums[0], nums[1]);
        }

        int first = 0;
        int second = 0;
        int ans = 0;
        for(int i = 0; i < len; i++){
            ans = Math.max(first, second + nums[i]);
            second = first;
            first = ans;
        }


        return  ans;
    }
}