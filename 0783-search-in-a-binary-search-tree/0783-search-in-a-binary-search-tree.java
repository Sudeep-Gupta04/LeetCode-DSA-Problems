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
    public TreeNode searchBST(TreeNode root, int val) {
        return helper(root,val);
    }
     public TreeNode helper(TreeNode root, int x){
        if(root==null) return null;
        if(root.val ==x) return root;
        TreeNode p1=null;TreeNode p2= null;
         if(root.val >x){
            p1 = helper(root.left,x);
        }else{
            p2 = helper(root.right,x);
        }
        if(p1==null) return p2;
        else return p1;
    }
}