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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return result;
        }

        queue.add(root);

        while(queue.size() > 0) {
            int n = queue.size();
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                if(current.left != null) {
                    queue.add(current.left);
                }
                if(current.right != null) {
                    queue.add(current.right);
                }
                temp.add(current.val);
            }
            result.add(temp);
        }

        return result;
    }
}