/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {

    // to store original node and the cloned node side by side
    // because random pointer could point back at nodes that are already cloned
    HashMap<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        // base case
        if(head == null) {
            return null;
        }

        Node cursor, cloneCursor;
        cursor = head;      // points to node in original linked list
        cloneCursor = clone(cursor);    // we start off by cloning the head, and store in hasmap
        map.put(cursor, cloneCursor);

        while(cursor != null) {
            // we clone in an iterative fashion
            cloneCursor.next = clone(cursor.next);
            cloneCursor.random = clone(cursor.random);
            // increments nexts
            cursor = cursor.next;
            cloneCursor = cloneCursor.next;
        }

        // return the cloned head from our map
        return map.get(head);
    }

    // utility
    private Node clone(Node node) {
        // base case
        if(node == null) {
            return null;
        }

        if(map.containsKey(node)) {
            // already cloned, return directly
            return map.get(node);
        } else {
            // clone it, put it then return
            Node clone = new Node(node.val);
            map.put(node, clone);
            return clone;
        }
    }
}