/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        return PreOrederTraversal(head);
    }
    private Node PreOrederTraversal(Node head) {
        if(head==null) return null;
        if(head.child==null && head.next==null) return head;
        Node left = PreOrederTraversal(head.child);
        Node right = PreOrederTraversal(head.next);
        Node node = merge(head,left,right);
        node.child = null;
        return node;
    }

    private Node merge(Node head, Node left, Node right) {
        if(left==null){
            head.next = right;
            right.prev = head;
            return head;
        }
        Node temp = left;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = right;
        if(right!=null)right.prev = temp;
        head.next = left;
        left.prev = head;
        return head;
    }
}