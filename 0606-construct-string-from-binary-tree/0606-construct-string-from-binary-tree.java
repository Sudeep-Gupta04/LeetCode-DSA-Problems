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
    public String tree2str(TreeNode root) {
        return helper(root);
    }
    public String helper(TreeNode root){
        if(root==null) return "";

        String com = root.val+"";
        String left = helper(root.left);
        String right = helper(root.right);

        if(left.length()==0 && right.length()==0) return com;

        if(left.length()==0) com+="()";
        else com += "(" + left + ")";

        if(right.length()!=0) com += "("+right+")";

        return com;
    }
}