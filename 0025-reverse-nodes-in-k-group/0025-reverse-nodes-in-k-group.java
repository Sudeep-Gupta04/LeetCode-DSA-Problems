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
    public int countNodes(ListNode head){
      ListNode temp = head;
      int c =0;
      while(temp!=null){
          c++;
          temp = temp.next;
      }
      return c;
  }
     
     public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        int c = countNodes(head);
        if(k==c) return reverseList(head);
        Stack<Integer> st = new Stack<>();


        ListNode temp = new ListNode(-1);
        ListNode Head = temp;

        for(int i =0;i<c;i++){
            if(st.size()==k){
                while(!st.isEmpty()){
                    ListNode node = new ListNode(st.pop());
                    temp.next=node;
                    temp = temp.next;
                }
            }if (st.size()<k) {
                st.push(head.val);
                head = head.next;
            }
        }
        ListNode h=null;
        if(st.size()==k){
            while (!st.isEmpty()){
                ListNode n = new ListNode(st.pop());
                temp.next = n;
                temp = temp.next;
            }
            return Head.next;  
        }
        while (!st.isEmpty()){
            ListNode n = new ListNode(st.pop());
            if(h==null) h = n;
            else {
                n.next = h;
                h = n;
            }
        }
        temp.next = h;
        return Head.next;
   }
   
   ListNode reverseList(ListNode head) {
       if (head.next == null) return head;
       ListNode prev = null;
       ListNode curr = head;
       ListNode fut = head.next;
       while (fut != null) {
           curr.next = prev;
           prev = curr;
           curr = fut;
           fut = fut.next;
       }
       curr.next = prev;
       return curr;
   }
}