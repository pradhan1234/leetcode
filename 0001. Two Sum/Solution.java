import java.util.Map;
// Space Complexity : O(n)
// Time Complexity : O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map map = new HashMap<Integer, Integer>();
        // we would store complement of a number and its index(because we want to return index)
        int c;
        
        for(int i = 0; i < nums.length; i++) {
            c = target - nums[i];   // complement
            if(map.containsKey(c)) { 
                // found indicates nums[i] + t == target, so return index
                return new int[]{(int)map.get(c), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
