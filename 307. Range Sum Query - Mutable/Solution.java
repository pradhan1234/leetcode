class NumArray {
    
    int[] segmentTree;
    int[] nums_backup;
    int n;
    
    public NumArray(int[] nums) {
        n = nums.length;
        if(n<=0) {
            return;
        }
        nums_backup = nums;
        int h = (int) (Math.ceil(Math.log(n) / Math.log(2)));   
        int max_size = 2 * (int) Math.pow(2, h) - 1; 
        segmentTree = new int[max_size];
        buildSegmentTree(nums, 0, 0, n-1); 
    }
    
    private int buildSegmentTree(int[] nums, int index, int startIndex, int endIndex) {
        if(startIndex == endIndex) {
            segmentTree[index] = nums[startIndex];
            return segmentTree[index];
        }
        
        int mid = startIndex + (endIndex - startIndex)/2;
        segmentTree[index] = buildSegmentTree(nums, 2*index+1, startIndex, mid) 
                                 + buildSegmentTree(nums, 2*index+2, mid+1, endIndex); 
        return segmentTree[index];
    }
    
    private void print(int[] a) {
        System.out.print("Elements: ");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
        System.out.println();
    }
    
    public void update(int i, int val) {
        if( i < 0 || i >= n) {
            return;
        }
        
        int delta = val - nums_backup[i];
        nums_backup[i] = val;
        updateSegmentTree(0, n-1, i, delta, 0);   
    }
    
    private void updateSegmentTree(int startIndex, int endIndex, int affectedIndex, int delta, int index) {
    
        if(affectedIndex < startIndex || affectedIndex > endIndex) {
            return;
        }
        
        segmentTree[index] += delta;
        if(startIndex<endIndex) {
            int mid = startIndex + (endIndex-startIndex)/2;
            updateSegmentTree(startIndex, mid, affectedIndex, delta, 2*index+1);
            updateSegmentTree(mid+1, endIndex, affectedIndex, delta, 2*index+2);
        }
    }
    
    public int sumRange(int i, int j) {
        if (i < 0 || j > n - 1 || i > j) {
            return 0;
        }
        return querySegmentTree(0, n-1, i, j, 0);
    }
    
    private int querySegmentTree(int startIndex, int endIndex, int qStartIndex, int qEndIndex, int index) {
        if(qStartIndex <= startIndex && qEndIndex >= endIndex) {
            return segmentTree[index];
        }
        
        if(startIndex > qEndIndex || endIndex < qStartIndex) {
            return 0;
        }
        
        int mid = startIndex + (endIndex - startIndex)/2;
        return querySegmentTree(startIndex, mid, qStartIndex, qEndIndex, 2*index+1) 
                + querySegmentTree(mid+1, endIndex, qStartIndex, qEndIndex, 2*index+2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 * ["NumArray","sumRange","sumRange","sumRange","update","update","update","sumRange","update","sumRange","update"]
 * [[[0,9,5,7,3]],[4,4],[2,4],[3,3],[4,5],[1,7],[0,8],[1,2],[1,9],[4,4],[3,4]]
 */

