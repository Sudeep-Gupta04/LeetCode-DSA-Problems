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
     public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        int count = getCount(head);
        return helper(head, count);
    }

    private int getCount(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    ListNode sortedMerge1(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null) {
            temp.next = head1;
        } else {
            temp.next = head2;
        }

        return dummy.next;
    }

    private ListNode helper(ListNode head, int count) {
        if (count <= 1) return head;

        ListNode mid = getMiddle(head, count);
        ListNode nextHalf = mid.next;
        mid.next = null;

        ListNode left = helper(head, count / 2);
        ListNode right = helper(nextHalf, count - count / 2);

        return sortedMerge1(left, right);
    }

    private ListNode getMiddle(ListNode head, int count) {
        int mid = count / 2;
        ListNode temp = head;
        for (int i = 1; i < mid; i++) {
            temp = temp.next;
        }
        return temp;
    }

}