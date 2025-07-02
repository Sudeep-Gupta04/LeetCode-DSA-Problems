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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return helper(root,low,high);
    }

    public TreeNode helper(TreeNode root, int l, int h){
        if(root==null) return null;

        if(root.val<l){
            root.left = null;
            return helper(root.right,l,h);
        }else if(root.val>h){
            root.right = null;
            return helper(root.left,l,h);
        }
        else if(root.val==h){
            root.right = null;
            //System.out.println("left");
            root.left = helper(root.left,l,h);
        }else if(root.val==l){
            root.left = null;
            //System.out.println("right");
            root.right = helper(root.right,l,h);
        }else {
            //System.out.println("both");
            root.left = helper(root.left,l,h);
            root.right = helper(root.right,l,h);
        }
       // System.out.println(root.val);
        return root;
    }
}