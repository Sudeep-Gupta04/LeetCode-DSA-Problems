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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        else {
            ListNode inc = head;
            ListNode tinc = head;
            ListNode dec = head.next;
            ListNode tdec = head.next;
            while (inc!=null && dec!=null && inc.next!=null && dec.next!=null){
                inc.next = inc.next.next;
                inc = inc.next;
                dec.next= dec.next.next;
                dec = dec.next;
            }
            if(inc!=null) inc.next = null;
            if(dec!=null) dec.next = null;
            

            inc.next = tdec;
            return tinc;
        }
    }
}