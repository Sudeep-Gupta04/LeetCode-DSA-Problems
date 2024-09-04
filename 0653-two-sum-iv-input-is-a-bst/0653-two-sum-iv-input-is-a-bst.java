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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> hs = new HashSet<>();
        return healper(root,k,hs);
    }
    public boolean healper(TreeNode root, int k,HashSet<Integer> hs){
        if(root==null) return false;
        if(hs.contains(k - root.val)) return true;
        else{
            hs.add(root.val);
        }
        boolean ans1 = healper(root.left,k,hs);
        boolean ans2 = healper(root.right,k,hs);
        return ans1 || ans2;
    }
}