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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int flag = 0;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll(); 
            if (node.left == null && node.right != null) return false;
            else if (node.left != null && node.right != null) {
                q.add(node.left);
                q.add(node.right);
            }
            else if (node.left != null && node.right==null){
                 q.add(node.left);
                    break;
            }
            else {
               break;            
            }
        }
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null || node.right != null) return false;
        }
        return true;
    }
}
