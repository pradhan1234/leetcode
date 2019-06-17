class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums) {
            set.add(n);
        }
        int longestLength = 0;
        int currentLength = 0;
        int currentValue;
        for(int n: nums) {
            if(!set.contains(n-1)) {
                currentValue = n;
                currentLength = 1;
                while(set.contains(currentValue+1)) {
                    currentValue++;
                    currentLength++;
                }
                longestLength = Math.max(longestLength, currentLength);
            }
        }

        return longestLength;
    }
}