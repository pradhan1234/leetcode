/**
 *  Range Sum Query - Mutable using Segment Tree
 *
 *  Build Segment Tree: O(n) time
 *  Space Complexity: O(n)
 *  Update Time: O(log n)
 *  Query Time: O(log n)
 */

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
        // The intuition behind the following workout is as follows:
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
    
    // buildSegmentTree: we build segment tree recursively
    // nums: original array
    // index: represents an element in segment tree structure
    // startIndex, endIndex: represent range of nums, of current call
    private int buildSegmentTree(int[] nums, int index, int startIndex, int endIndex) {
        // base case
        // when nums[startIndex .. endIndex] correspond to single element
        // create a node for it in segmentTree at index
        if(startIndex == endIndex) {
            segmentTree[index] = nums[startIndex];
            return segmentTree[index];
        }
        // recursive building step
        int mid = startIndex + (endIndex - startIndex)/2;
        // the node at segment tree at index, represents the range under it
        // which is sum of both its children.
        // modify start/end indices and current index and make recursive call
        segmentTree[index] = buildSegmentTree(nums, 2*index+1, startIndex, mid) 
                                 + buildSegmentTree(nums, 2*index+2, mid+1, endIndex); 
        return segmentTree[index];
    }
    
    // print array
    private void print(int[] a) {
        System.out.print("Elements: ");
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
        System.out.println();
    }
    
    // to update element at index i in original array to val
    public void update(int i, int val) {
        // check i in range?
        if( i < 0 || i >= n) {
            return;
        }

        int delta = val - nums_backup[i]; // diff
        nums_backup[i] = val; // update our backup copy
        // update the segment tree
        updateSegmentTree(0, n-1, i, delta, 0);   
    }
    
    // updateSegmentTree: we update the segment tree recursively
    // startIndex, endIndex, affectedIndex correspond to original array
    // index corresponds to index in segment tree, for current call
    private void updateSegmentTree(int startIndex, int endIndex, int affectedIndex, int delta, int index) {
        // check affectedIndex in range?
        if(affectedIndex < startIndex || affectedIndex > endIndex) {
            return;
        }
        // update current node of segment tree with delta
        segmentTree[index] += delta;
        // recursively update segment tree
        if(startIndex < endIndex) {
            int mid = startIndex + (endIndex-startIndex)/2;
            updateSegmentTree(startIndex, mid, affectedIndex, delta, 2*index+1);
            updateSegmentTree(mid+1, endIndex, affectedIndex, delta, 2*index+2);
        }
    }
    
    // returns sum range of arr[i .. j]
    public int sumRange(int i, int j) {
        // check validity
        if (i < 0 || j > n - 1 || i > j) {
            return 0;
        }
        return querySegmentTree(0, n-1, i, j, 0);
    }
    
    // querySegmentTree: we query the segment tree recursively
    // startIndex, endIndex corresponds to indices in original array
    // qStartIndex, qEndIndex corresponds to query indices in original array
    // index corresponds to node in segment tree of current call
    private int querySegmentTree(int startIndex, int endIndex, int qStartIndex, int qEndIndex, int index) {
        // We have 3 cases here to take care of:
        // 1. Exact Match
        // 2. No Overlap
        // 3. Partial Overlap
        
        // Exact Match: return the value
        if(qStartIndex <= startIndex && qEndIndex >= endIndex) {
            return segmentTree[index];
        }
        // No Overlap: return 0
        if(startIndex > qEndIndex || endIndex < qStartIndex) {
            return 0;
        }
        // propagate recursively
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

