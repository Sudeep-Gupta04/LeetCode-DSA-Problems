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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
     List<List<Integer>> outer = new ArrayList<>();
        if(root==null) return outer;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean check =true;
        while (!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> internal = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode root1 = q.remove();
                internal.add(root1.val);
                if(root1.left!=null) q.add(root1.left);
                if(root1.right != null) q .add(root1.right);
            }
            if(check){
                outer.add(internal);
                check =false;
            }
            else {
                outer.add(internal.reversed());
                check =true;
            }
            
        }
        return outer;   
    }
}