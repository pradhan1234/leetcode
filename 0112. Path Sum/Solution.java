/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 *
 * Time Complexity : O(n)
 * Space Complexity : O(lg n) average case; worst case O(n)
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        // base case: root is null
        if(root == null) {
            return false;
        }
        // case: root is leaf
        if(root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        boolean hasLeft = false, hasRight = false;
        // consume root.val and recurse on left
        if(root.left != null) {
            hasLeft = hasPathSum(root.left, sum - root.val);
        }
        // consume root.val and recurse on right
        if(root.right != null) {
            hasRight = hasPathSum(root.right, sum - root.val);
        }

        return hasLeft || hasRight;
    }
}
