/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void recoverTree(TreeNode root) {
    ArrayList<TreeNode[]> al = new ArrayList<>();
    Stack<TreeNode> st = new Stack<>();
    TreeNode t = root;

    while (t != null) {
        st.add(t);
        t = t.left;
    }

    TreeNode prev = null;
    while (!st.isEmpty()) {
        TreeNode curr = st.pop();

        if (prev != null) {
            if (curr.val < prev.val) {
                al.add(new TreeNode[]{prev, curr});
            }
        }
        prev = curr;

        if (curr.right != null) {
            TreeNode temp = curr.right;
            while (temp != null) {
                st.add(temp);
                temp = temp.left;
            }
        }
    }
    TreeNode first = al.get(0)[0];
    TreeNode second = al.get(al.size() - 1)[1];
    int fval = first.val;
    first.val = second.val;
    second.val = fval;
    }
}