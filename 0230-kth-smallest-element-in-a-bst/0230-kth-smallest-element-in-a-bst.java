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
    int x = 0;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return ans;
    }
    public void helper(TreeNode node , int k){
        if(node==null) return;
        helper(node.left,k);
        x++;
        if(x==k){
            ans = node.val;
        }
        helper(node.right,k);
        return;
    }
}