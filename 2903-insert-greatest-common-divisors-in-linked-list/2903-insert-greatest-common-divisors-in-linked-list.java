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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null) return null;
        ListNode temp = head;
        while(temp.next!=null){
            ListNode t = temp.next;
            ListNode n = new ListNode(gcd(temp.val,t.val));
            temp.next = n;
            n.next = t;
            temp = temp.next.next;
        }
        return head;
    }
     public  int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}