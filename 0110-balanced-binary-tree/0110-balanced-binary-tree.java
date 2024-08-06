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
     public static int checkHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(checkHeight(root.left),checkHeight(root.right))+1;
    }
    public boolean isBalanced(TreeNode root) {
    if(root==null) return true;
    else if(Math.abs(checkHeight(root.left)-checkHeight(root.right))< 2 && isBalanced(root.right) && isBalanced(root.left)){
        return true;
    }
    return false;  
    }
}