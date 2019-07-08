/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Intution is to split the array into two and then check both the halfs for if they are same or not.
 * The second half has to be reversed to check for Palindrome.
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode fast = head;
        ListNode slow = head;

        /**
         * Two Pointer method.
         */
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        /**
         *Check for the condition where there are only two elements in the Linked List.
         */
        if(fast == head && fast.val != fast.next.val){
            return false;
        }

        /**
         * Split the Linked List in 2 parts and Reverse the second half of the Linked List
         */
        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode current = secondHead;
        ListNode next = null;
        ListNode prev = null;

        /**
         * Reverse the Second half
         */
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        secondHead = prev;

        /**
         * Traverse through both the halfs and check if they are palindrome or not.
         */
        while(head != null && secondHead != null){
            if (head.val != secondHead.val){
                return false;
            }
            head = head.next;
            secondHead = secondHead.next;
        }

        return true;
    }
}