class NumArray {

    int[] segmentTree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        int h = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, h) - 1;
        segmentTree = new int[max_size];
        buildSegmentTree(nums, 0, 0, n-1);

        print(segmentTree);
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

    }

    public int sumRange(int i, int j) {
        return 0;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */