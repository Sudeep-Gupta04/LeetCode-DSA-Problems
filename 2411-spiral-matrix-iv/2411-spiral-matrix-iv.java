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
   ListNode root;
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] mat = new int[m][n];
        ListNode temp = head;
        int c =0;
        while(temp.next!=null){
            c++;
            temp = temp.next;
        }
        if(c<m*n){
          for(int i =c;i<m*n;i++){
              temp.next = new ListNode(-1);
              temp = temp.next;
          }
        }
        root = head;
        int low = 0;
        int high = mat.length-1;
        int start = 0;
        int end = mat[0].length-1;
        while(low<=high && start<=end) {
            fillBoundary1(low, high, start, end, mat);
            low++;
            high--;
            end--;
            start++;
        }
        return mat;
    }
    private void fillBoundary1( int low, int high, int start, int end,int[][] mat) {
        for (int i = start; i <= end; i++) {
            mat[low][i] = root.val;
            root = root.next;
        }
        for (int i = low + 1; i <= high; i++) {
            mat[i][end] = root.val;
            root = root.next;
        }
        if (low < high) {
            for (int i = end - 1; i >= start; i--) {
                mat[high][i] = root.val;
                root = root.next;
            }
        }
        if (start < end) {
            for (int i = high - 1; i >= low + 1; i--) {
                mat[i][start] = root.val;
                root = root.next;
            }
        }
    }
}