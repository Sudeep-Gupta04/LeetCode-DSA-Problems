/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        helper(root, q);
        return root;
    }

    public void helper(Node root, Queue<Node> q) {
        if (root == null) return;
        q.add(root);

        while (!q.isEmpty()) { 
            int size = q.size(); 
            for (int i = 1; i <= size; i++) {
                Node temp = q.remove();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right); 
                if (i == size) {
                    temp.next = null;
                } else {
                    temp.next = q.peek();
                }
            }
        }
    }
}