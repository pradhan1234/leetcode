/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) avg case, O(n) worst case.
 *
 * Idea: traverse the tree using dfs
 *
 *  L:20, R:30
 *  tree:
 *          25
 *        /   \
 *      15    45
 *
 *  result: 25
 *
 */
class Solution {

    public int rangeSumBST(TreeNode root, int L, int R) {
        return traverse(root, L, R);
    }

    // invariant: each node returns the sum in range corresponding to its subtree
    public int traverse(TreeNode node, int L, int R) {
        // base case
        if (node == null) {
            return 0;
        }
        // inclusion of current node as it is in range, plus recurse on its left and right
        // say: node.val = 25, L: 20 R:30        
        if (L <= node.val && node.val <= R) {
            return traverse(node.left, L, R) + node.val + traverse(node.right, L, R);
        }
        // left branch & current node excluded
        // say: node.val = 15, L: 20 R:30
        if (L > node.val) {
            return traverse(node.right, L, R);
        }
        // right branch & current node excluded
        // say: node.val = 45, L: 20 R:30
        if (node.val > R) {
            return traverse(node.left, L, R);
        }
        // should never reach here!
        return -1;
    }
}
