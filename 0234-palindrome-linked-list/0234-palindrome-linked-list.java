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
    public boolean isPalindrome(ListNode head) {
            
        if(head == null || head.next == null)
             return true;
         
    
         ListNode dummy_head = null;
         ListNode current = head;
         while (current != null) {
             ListNode newNode = new ListNode(current.val);
             newNode.next = dummy_head;
             dummy_head = newNode;
             current = current.next;
         }
         
       
         ListNode p1 = head;
         ListNode p2 = dummy_head;
         while (p1 != null && p2 != null) {
             if (p1.val != p2.val)
                 return false;
             p1 = p1.next;
             p2 = p2.next;
         }
         
         return true;
    }
}