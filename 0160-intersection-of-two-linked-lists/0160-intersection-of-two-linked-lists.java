/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        int s1=0,s2=0;
        while(t1!=null){
            t1 = t1.next;
            s1++;
        }
        t1 = headA;
        while(t2!=null){
            t2 = t2.next;
            s2++;
        }
        t2 = headB;
        if(s2>s1){
            for(int i=0;i<s2-s1;i++){
               t2 = t2.next;
            }
        }
        else {
            for(int i=0;i<s1-s2;i++){
                t1 = t1.next;
            }
        }
        while (t1!=t2){
            t2 = t2.next;
            t1 = t1.next;
        }
        return t1;
    }
}