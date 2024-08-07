/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
     public void reorderList(ListNode head) {
        if(head==null|| head.next==null||head.next.next==null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode dummy= new ListNode(-1);
        dummy.next = head;
        ListNode temp = head;

        ListNode next_half = slow.next;
        slow.next = null;
        ListNode half = reverseList(next_half);

        while (half!=null){
            temp = temp.next;
            dummy = dummy.next;
            dummy.next = half;
            half = half.next;
            dummy = dummy.next;
            dummy.next = temp;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head.next==null ) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode fut = head.next;
        while (fut!=null){
            curr.next = prev;
            prev = curr;
            curr = fut;
            fut = fut.next;
        }
        curr.next = prev;
        return curr;
    }
}