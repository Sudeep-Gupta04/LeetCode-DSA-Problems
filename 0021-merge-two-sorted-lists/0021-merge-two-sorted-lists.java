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
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = new ListNode(-101);
        ListNode Head = temp;
        ListNode h1 = list1;
        ListNode h2 = list2;
        while (h1!=null && h2!=null){
            if(h1.val>=h2.val){
                ListNode node =  new ListNode(h2.val);
                temp.next = node;
                temp=temp.next;
                h2 = h2.next;
            }else {
                ListNode node =  new ListNode(h1.val);
                temp.next = node;
                temp=temp.next;
                h1 = h1.next;
            }
        }
        while (h1!=null){
            ListNode node =  new ListNode(h1.val);
            temp.next = node;
            temp=temp.next;
            h1 = h1.next;
        }
        while (h2!=null){
            ListNode node =  new ListNode(h2.val);
            temp.next = node;
            temp=temp.next;
            h2 = h2.next;
        }
        return Head.next;
    }
}