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
    HashMap<TreeNode,Integer> hm; 
    public int rob(TreeNode root) {
        this.hm = new HashMap<>();
        return helper(root);
    }

    public int helper(TreeNode root){
        if(root==null) return 0;
        if(hm.containsKey(root)) return hm.get(root);
        // take ad move to child to clild
        int rec =0;
        int take = root.val;
        rec += ((root.left!=null)?(helper(root.left.left) + helper(root.left.right)):0);
        rec += ((root.right!=null)?(helper(root.right.left) + helper(root.right.right)):0);
        take += rec;
        
        int ntake = helper(root.left) + helper(root.right);
        int ans = Math.max(ntake,take);

        hm.put(root,ans);
        return ans;
    }
}