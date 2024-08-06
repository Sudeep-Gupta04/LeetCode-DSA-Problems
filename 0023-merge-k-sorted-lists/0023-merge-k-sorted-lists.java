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
       public ListNode mergeKLists(ListNode[] lists) {

        ListNode ans = new ListNode(-1,null);
        ListNode head = ans;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i =0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }

        while (!pq.isEmpty()){
            ListNode linklist =  pq.remove();
            if (linklist == null) {
                pq.remove(linklist.next);
                continue;
            }
            else if(linklist!=null){
                ListNode node = new ListNode(linklist.val,null);
                ans.next = node;
                ans = ans.next;
                if(linklist.next!=null){
                    pq.add(linklist.next);
                }
               
            }
        }
        return head.next;
    }
}