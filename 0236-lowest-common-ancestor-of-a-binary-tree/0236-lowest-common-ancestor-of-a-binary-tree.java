/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val || root.val==q.val) return root;
        TreeNode ans1 = lowestCommonAncestor(root.left,p,q);
        if(ans1==null){
            TreeNode ans2 = lowestCommonAncestor(root.right,p,q);
            return ans2;
        }
        else if(ans1!=null){
            TreeNode ans2 = lowestCommonAncestor(root.right,p,q);
            if(ans2!=null) return root;
        }
        return ans1;
    }
}