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
     int dia =0;
      public int diameterOfBinaryTree(TreeNode root) {
       
        diameterOfBinaryTree1(root);
        return dia;
        
    }
    public int diameterOfBinaryTree1(TreeNode root) {
        if(root==null) return 0;
        int lftHight = diameterOfBinaryTree1(root.left);
        int rightHeight = diameterOfBinaryTree1(root.right);
        dia = Math.max(dia,lftHight+rightHeight);
        
        return (Math.max(lftHight,rightHeight)+1);
    }
}