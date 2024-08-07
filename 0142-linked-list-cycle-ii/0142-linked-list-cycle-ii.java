/**
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
    ListNode slow;
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode fast = head;
        slow = head;
        do {
            slow = slow.next;
            fast= fast.next.next;
            if(slow==fast) return true;
        }while (slow!=null && fast!=null && fast.next!=null);
        return false;
    }
    public ListNode detectCycle(ListNode head) {
        boolean ans = hasCycle(head);
        if(!ans) return null;
        else{
            ListNode temp = head;
            while(temp != slow){
                temp = temp.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}