/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    ListNode _head;
    
    public ListNode reverseList(ListNode head) {
        // setting up
        ListNode cursor = head;
        _head = head;
        
        // call to recursive function
        reverseHelper(cursor);
        
        // return reversed linked list
        return _head;
    }
    
    private ListNode reverseHelper(ListNode cursor) {
                
        // base conditions
        if(cursor == null) {
            return cursor;
        }
        
        // this indicates last node, we set _head to it
        if(cursor.next == null) {
            _head = cursor;
            return cursor;
        }
        
        // now we call reverse on cursor.next,
        // rev(1): 1 --> 2 --> 3 --> 4 --> 5 --> NULL
        // cursor = 1; rev(2): 2 --> 3 --> 4 --> 5 --> NULL
        // cursor = 1; _head = 5 --> 4 --> 3 --> 2 --> NULL; function returns reference to the last node in this reversed list, we set it's next to cursor
        (reverseHelper(cursor.next)).next = cursor;
        cursor.next = null;
        
        return cursor;
    }
}
