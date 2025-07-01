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

     public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        return helper(root,0);
    }
    public int helper(TreeNode root,int inner){
        if(root.left==null && root.right==null){
            return inner*10 + root.val;
        }
        int ans = 0;
        if(root.left!=null){
            ans += helper(root.left,inner*10+root.val);
        }
        if(root.right!=null){
            ans += helper(root.right,inner*10+root.val);
        }

        return ans;
    }
}