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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int size =0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
      temp = head;
      int ans=0;
      while(temp!=null){
          ans+=temp.val*Math.pow(2,size-1);
          temp = temp.next;
          size--;
      }
      return ans;
    }
}