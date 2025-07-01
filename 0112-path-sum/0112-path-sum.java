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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return helper(root,targetSum);
    }

    public boolean helper(TreeNode root,int tar){
        if(root==null){
            if(tar==0) return true;
            return false;
        }
        return helper(root.left,tar-root.val)|| helper(root.right,tar-root.val);
    }
}