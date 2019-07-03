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
    public boolean isSymmetric(TreeNode root) {
        return symmetricNodes(root, root);
    }

    public boolean symmetricNodes(TreeNode node1, TreeNode node2){
        //Base Case
        if(node1 == null && node2 == null)
            return true;

        //The most Crucial step where we need to check the alternate elements from both the nodes.
        //Check for Left of First and Right of Second & Right of First and Left of Second
        if(node1 != null && node2 != null && node1.val == node2.val)
            return( symmetricNodes(node1.left, node2.right) && symmetricNodes(node1.right, node2.left) );

        return false;
    }
}