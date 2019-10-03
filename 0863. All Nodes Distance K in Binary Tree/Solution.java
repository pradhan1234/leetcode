/**
 * We are given a binary tree (with root node root), a target node, and an
 * integer value K.
 * 
 * Return a list of the values of all nodes that have a distance K from the
 * target node. The answer can be returned in any order.
 * 
 * Idea:
 * Augment the tree to a graph data structure, dfs would create the graph structure.
 * Then, use bfs to find nodes at distance K from the target node.
 * 
 * Leetcode Result:
 * Runtime: 2 ms, faster than 70.75% of Java online submissions for All Nodes Distance K in Binary Tree.
 * Memory Usage: 37.2 MB, less than 78.95% of Java online submissions for All Nodes Distance K in Binary Tree.
 */
class Solution {
    GraphNode targetNode;
    TreeNode _target;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        _target = target;
        GraphNode rootNode = new GraphNode(root, null, null, null);
        dfs(rootNode);

        List<Integer> result = new LinkedList<>();
        bfs(targetNode, result, K);
        return result;
    }

    private void dfs(GraphNode node) {
        if (node == null) {
            return;
        }

        if (node.treeNode == _target) {
            targetNode = node;
        }

        if (node.treeNode.left != null) {
            node.left = new GraphNode(node.treeNode.left, node, null, null);
            dfs(node.left);
        }

        if (node.treeNode.right != null) {
            node.right = new GraphNode(node.treeNode.right, node, null, null);
            dfs(node.right);
        }
    }

    private void bfs(GraphNode node, List<Integer> result, int K) {
        Queue<GraphNode> queue = new LinkedList<>();
        node.visited = true;
        queue.add(node);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            // System.out.println("Queue: " + queue);
            if (currentLevel == K) {
                for (GraphNode n : queue) {
                    result.add(n.treeNode.val);
                }
                return;
            }
            int nodesLevel = queue.size();
            for (int i = 0; i < nodesLevel; i++) {
                GraphNode current = queue.remove();
                if (current.parent != null && !current.parent.visited) {
                    current.parent.visited = true;
                    queue.add(current.parent);
                }
                if (current.left != null && !current.left.visited) {
                    current.left.visited = true;
                    queue.add(current.left);
                }
                if (current.right != null && !current.right.visited) {
                    current.right.visited = true;
                    queue.add(current.right);
                }
            }
            currentLevel++;
        }
    }
}

class GraphNode {
    TreeNode treeNode;
    GraphNode parent, left, right;
    boolean visited;

    GraphNode(TreeNode treeNode, GraphNode parent, GraphNode left, GraphNode right) {
        this.treeNode = treeNode;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return "(" + this.treeNode.val + ")";
    }
}