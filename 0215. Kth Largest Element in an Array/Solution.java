class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // insert first k elements into heap
        for(int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        // if array element is better than the one on top of minHeap
        // perform remove followed bby an add
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap.peek()) {
                minHeap.remove();
                minHeap.add(nums[i]);
            }
        }
        // the heap contains k largest elements
        // the one on top is kth largest as its a minHeap
        return minHeap.peek();
    }
}
