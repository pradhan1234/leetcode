// Space Complexity: O(n)
// Time Complexity: O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        // The idea used here is pretty simple to understand.
        // Before diving into that, we have a simple O(nlgn) sorting based solution for the problem.
        // Sort the array, traverse it to find the longest consecutive sequence.
        
        // Let's talk about a better approach
        Set<Integer> set = new HashSet<>();
        for(int n: nums) {
            set.add(n);
        }
        // key point: the streak start from smallest element that belongs to that streak
        // there we only proceed iff element n-1 is not present, which implies n is the smallest element.
        // keep track of current and global lengths.
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
