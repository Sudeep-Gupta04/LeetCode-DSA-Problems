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
    int Ans=0;
    public int findBottomLeftValue(TreeNode root) {
    heapMe(root);
    return Ans;
    }

     public static int checkHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(checkHeight(root.left),checkHeight(root.right))+1;
    }
    private void heapMe(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) Ans=root.val;
        
        if(checkHeight(root.left) >= checkHeight(root.right)){
            heapMe(root.left);
        }
        else {
            heapMe(root.right);
        }
    }
}