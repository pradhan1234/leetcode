/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Time Complexity: O(n)    n = number of nodes in the LinkedList
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        //Base Case for LinkedList is null.
        if(head == null)
            return head;

        //Find the length of the LinkedList.
        int listLength = 0;
        ListNode runner = head;
        ListNode last = head;
        while(runner != null){
            listLength++;
            last = runner;
            runner = runner.next;
        }

        // If the rotation is greater then the length Modulo can be applied.
        listLength -= (k % listLength);
        runner = head;
        for(int i = 0; i < listLength-1; i++){
            runner = runner.next;
        }
        //Get the node from where the rotation is to be performed and then change the Pointers.
        //Tail of the List points to the head and the Runner becomes the tail and element after that becomes te new Head.
        ListNode previousHead = head;
        last.next = previousHead;
        head = runner.next;
        runner.next = null;

        return head;
    }
}