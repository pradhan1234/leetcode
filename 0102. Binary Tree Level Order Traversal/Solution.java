/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Space Complexity: O(n)
// Time Complexity: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Simple Breadth First Search Treversal of the tree.
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // base case
        if(root == null) {
            return result;
        }
        // start by adding root to the queue.
        queue.add(root);

        while(queue.size() > 0) {
            int n = queue.size();   // helps track all nodes that belong to a level
            List<Integer> temp = new LinkedList<>();    // holds nodes of a level
            for(int i = 0; i < n; i++) {
                // while visiting a node, add its children to queue
                TreeNode current = queue.poll();
                temp.add(current.val);
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            // add to result
            result.add(temp);
        }
        return result;
    }
}
