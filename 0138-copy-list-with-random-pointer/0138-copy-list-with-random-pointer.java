/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
       public Node copyRandomList(Node head) {
        // your code here
        
        Node temp = new Node(-1);
        Node Head = temp;
        Node h = head;
        int i = 1;
        HashMap<Node, Integer> mp = new HashMap<>();
        mp.put(null, 0);
        while (h != null) {
            mp.put(h, i);
            i++;
            Node node = new Node(h.val); // Changed from h.data to h.val
            temp.next = node;
            temp = temp.next;
            h = h.next;
        }
        h = head;
        temp = Head.next;
        while (h != null) {
            if (mp.get(h.random) != 0) { // Changed from h.arb to h.random
                Node placing = Head.next;
                for (i = 1; i < mp.get(h.random); i++) { // Changed from h.arb to h.random
                    placing = placing.next;
                }
                temp.random = placing; // Changed from temp.arb to temp.random
            }
            else {
               temp.random = null; 
            }
            temp = temp.next;
            h = h.next;
        }
        return Head.next;
    }
}