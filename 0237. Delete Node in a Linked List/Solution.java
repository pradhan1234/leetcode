/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Space Complexity: O(1)
 * Time Complexity: O(1)
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 */

class Solution {
    public void deleteNode(ListNode node) {
        // we do not have access to head, or any other reference except the node to be deleted itself.
        // so only option we have is to swap the value with the next node
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
