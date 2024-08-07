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
    int count = 0;
    public ListNode reverseList(ListNode head) {
        if(head.next==null ) {
            count++;
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode fut = head.next;
        while (fut!=null){
            count++;
            curr.next = prev;
            prev = curr;
            curr = fut;
            fut = fut.next;
        }
        count++;
        curr.next = prev;
        return curr;
    }
     public int[] nextLargerNodes(ListNode head) {
        ListNode node = reverseList(head);
        int[] arr = new int[count];
        int k =count-1;
        Stack<Integer> st = new Stack<>();
        while(node!=null){
            while(!st.isEmpty() && st.peek()<=node.val){
                st.pop();
            }
            if(st.isEmpty()) arr[k--]=0;
            else arr[k--]=st.peek();

            st.push(node.val);
            node = node.next;
        }
        return arr;
    }
}