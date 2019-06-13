/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // base case: LL null or single node.
        if(head == null || head.next == null) {
            return head;
        }
        // Example:
        // head --> 1 --> 2 --> 3 --> 4 --> NULL

        // holds rest of the reversed list.
        ListNode reversed = reverseList(head.next);
        // head --> 1 ------->-------
        //                          |
        // reversed --> 4 --> 3 --> 2 --> NULL
        //
        // pointer rearrangement:
        head.next.next = head;
        head.next = null;
        // reversed --> 4 --> 3 --> 2 --> 1 --> NULL
        return reversed;
    }
}
