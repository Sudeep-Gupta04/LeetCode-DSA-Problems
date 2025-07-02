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
    public TreeNode bstToGst(TreeNode root) {
       List<TreeNode> l = new ArrayList<>();
       preorder(root,l);
       int[] sum = new int[l.size()];
       sum[l.size()-1] = l.get(l.size()-1).val;
       for(int i = l.size()-2;i>=0;i--){
        sum[i] = sum[i+1]+l.get(i).val;
       }
       for(int i =0;i<l.size();i++){
            TreeNode nd = l.get(i);
            nd.val = sum[i];
       }
       return root;
    }
 
    public void preorder(TreeNode root,List<TreeNode> l){
        if(root==null) return;

        preorder(root.left,l);
        l.add(root);
        preorder(root.right,l);
    }
}