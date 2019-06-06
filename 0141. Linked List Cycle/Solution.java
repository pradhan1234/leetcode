/**
 *
 * Given a linked list, determine if it has a cycle in it.
 * Intuition: Classic Floyd Cycle Detection algorithm using slow and fast pointers.
 *
 * Space Complexity: O(1)
 * Time Complexity: O(n)
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {

        if(head == null) {
            return false;
        }

        ListNode hare, rabbit;
        hare = head;
        rabbit = head;

        while(rabbit.next != null && rabbit.next.next != null) {
            hare = hare.next;
            rabbit = rabbit.next.next;
            if(hare == rabbit) {
                return true;
            }
        }

        return false;
    }
}
