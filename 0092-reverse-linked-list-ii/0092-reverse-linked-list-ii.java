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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        
        ListNode tempL = head;
        ListNode tempR = head;
        int count =1;
        for(int i =1;i<right;i++){
            if(count<left-1) {
                tempL = tempL.next;
                count++;
            }
            tempR = tempR.next;
        }
        ListNode rotaing_start;
        if(left==1){
            rotaing_start = tempL;
        }
        else rotaing_start = tempL.next;
        
        ListNode second_half = tempR.next;
        tempR.next = null;
        
        ListNode node = reverseList(rotaing_start);
        ListNode temp = node;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = second_half;
        if(left==1){
           return node; 
        }
        tempL.next = node;
        return head;
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