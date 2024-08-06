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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        
        if (root.val > key) {
            root.left = deleteNode(root.left, key); // Update the left child
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key); // Update the right child
        } else {
            
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // Node with two children
                root.val = minValue(root.right);

               
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    private int minValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            root = root.left;
            minValue = root.val;
        }
        return minValue;
    }
}