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
    List<List<Integer>> outer;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        this.outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        if(root==null) return outer;
        helper(root,targetSum,inner);
        return outer;
    }
    public void helper(TreeNode root,int tar,List<Integer> inner){
        if(root.left==null && root.right==null){
            if(root.val==tar){
                inner.add(root.val);
                outer.add(new ArrayList<>(inner));
                inner.remove(inner.size()-1);
                return;
            } 
            else return;
        }
        boolean ans = false;
        if(root.left!=null){
            inner.add(root.val);
            helper(root.left,tar-root.val,inner);
            inner.remove(inner.size()-1);
        } 
        if(root.right!=null){
            inner.add(root.val);
            helper(root.right,tar-root.val,inner);
            inner.remove(inner.size()-1);
        } 
        
        return;
    }
}