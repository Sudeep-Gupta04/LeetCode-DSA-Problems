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
     public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        return helper(preorder, inorder, mp, 0, inorder.length - 1, 0);

    }

    private TreeNode helper(int[] preorder, int[] inorder, HashMap<Integer, Integer> mp, int start,int end,int preIndex) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[preIndex];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = mp.get(rootVal);

        root.left = helper(preorder, inorder, mp, start, inIndex - 1, preIndex + 1);
        root.right = helper(preorder, inorder, mp, inIndex + 1, end, preIndex + inIndex - start + 1);

        return root;
    }
}