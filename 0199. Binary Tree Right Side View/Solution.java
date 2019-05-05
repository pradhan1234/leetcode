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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();  // to store result
        Queue<TreeNode> queue = new LinkedList<>(); // for level order traversal aka bfs

        // base case
        if(root == null) {
            return result;
        }

        // start bfs, by putting root in queue
        queue.add(root);

        while(queue.size() > 0) {
            int n = queue.size();   // number of children in the level that we are processing
            // n = 1, as starting from root
            for(int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                // add left and right children to queue if they exist
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
                if(i==n-1){ // right most in level
                    result.add(current.val);
                }
            }
        }
        return result;
    }
}