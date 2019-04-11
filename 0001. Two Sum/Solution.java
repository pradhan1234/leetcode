import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map map = new HashMap<Integer, Integer>();
        int c;

        for(int i = 0; i < nums.length; i++) {
            c = target - nums[i];
            if(map.containsKey(c)) {
                return new int[]{(int)map.get(c), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
