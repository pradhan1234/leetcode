/**
 *  Build Segment Tree: O(n) time
 *  Space Complexity: O(n)
 *  Update Time: O(log n)
 *  Query Time: O(log n)
 */

// TODO: add comments

class NumArray {
    
    // This version of Segment Tree is a complete binary tree,
    // we use an array to represent it.
    int[] segmentTree;  
    // This version can be optimized for better space complexity, currently it isn't.
    // So we save a copy of actual array as well.
    // Because we don't know which leaves would correspond to which element.
    // I think we could determine that, but need to work it out.
    int[] nums_backup;  // to store the actual array elements.
    int n;  // size
    
    public NumArray(int[] nums) {
        n = nums.length;
        if(n<=0) {
            return;
        }
        nums_backup = nums; // save it.
        // The intuitionn behind the following workout is as follows:
        // If we had size of elements in given array as power of 2, 
        // we would be able to construct perfectly complete binary tree.
        //
        //  Eg: n = 8, 10 20 30 40 50 60 70 80
        //  Segment Tree for given array, h = 3, max_size = 8        
        //                                  360[0:7] <--------------- [range in actual array]
        //                          /                    \
        //                  100[0:3]                       260[4:7]
        //               /      \                       /         \ 
        //         30              70               110            150        
        //        /   \           /    \          /    \           /   \
        //     10      20       30      40       50    60       70       80
        int h = (int) (Math.ceil(Math.log(n) / Math.log(2)));   
        int max_size = 2 * (int) Math.pow(2, h) - 1; 
        // In case where n is not power of two, we find the next smallest power of two > n.
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

