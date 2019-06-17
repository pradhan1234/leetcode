/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    int maxValue;   // global value

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    // goal of this function is to return max path sum including node
    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // recurse on left and right
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        // update max value iff we get a max path sum with left + node + right
        maxValue = Math.max(maxValue, left + node.val + right);
        return Math.max(left, right) + node.val; // path sum including node
    }
}