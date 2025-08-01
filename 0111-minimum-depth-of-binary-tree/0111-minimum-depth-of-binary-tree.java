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
    public int minDepth(TreeNode root) {
        return helper(root);
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;

        int left = helper(root.left);
        int right = helper(root.right);

        if(left==0) return 1+right;
        else if(right==0) return 1+left;
        else {
            return Math.min(left,right)+1;
        }
    }
}