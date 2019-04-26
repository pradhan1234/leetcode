class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort array
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int p, q, r, sum;

        for(p = 0; p < nums.length - 2; p++) {
            // eliminate duplicates
            if(p>0 && nums[p] == nums[p-1]) {
                // no need to increment p, for loop shall handle it
                continue;
            }

            q = p + 1;
            r = nums.length - 1;

            while(q < r) {
                sum = nums[p] + nums[q] + nums[r];
                // if sum is < 0, increment q
                if(sum < 0) {
                    q++;
                } else if(sum > 0) { // sum > 0, decrement r
                    r--;
                } else { //got target, add to result
                    result.add(Arrays.asList(nums[p], nums[q], nums[r]));
                    // increment q to skip duplicates if any
                    while(q<r && nums[q] == nums[q+1]) {
                        q++;
                    }
                    // decrement r to skip duplicates if any
                    while(q<r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    q++;
                    r--;
                }
            }
        }
        return result;
    }
}
