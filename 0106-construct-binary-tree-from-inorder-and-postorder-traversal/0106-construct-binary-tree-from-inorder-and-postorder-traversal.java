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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) hm.put(inorder[i], i);

        return helper(n - 1, hm, 0, n - 1, postorder);
    }

    public TreeNode helper(int postidx, HashMap<Integer, Integer> hm, int s, int e, int[] postorder) {
        if (s > e || postidx<0) return null;

        TreeNode root = new TreeNode(postorder[postidx]);
        int inordidx = hm.get(root.val);
        //int countLeftNodes = inordidx - s;
        int rightSubtreenode = (e-inordidx);
        root.right = helper(postidx - 1, hm, inordidx + 1, e, postorder);
        root.left = helper(postidx - rightSubtreenode - 1, hm, s, inordidx - 1, postorder);


        return root;
    }
}
