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
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    // As the root elements could be Integer.(MIN/MAX)_VALUE
    // We cannot use those as sentinels, well we could use it using null markers
    // this is the easy way :)
    private boolean validateBST(TreeNode root, long lowerBound, long upperBound) {
        // base case
        if(root == null) {
            return true;
        }
        // invariant: lowerBound < root.val < upperBound
        if (root.val >= upperBound || root.val <= lowerBound){
            return false;
        }
        // update bounds and recurse
        // if going down the left branch, update upper bound to root.val
        // similarly for thr right branch, lower bound becomes root.val
        return validateBST(root.left, lowerBound, root.val) && validateBST(root.right, root.val, upperBound);        
    }
}
