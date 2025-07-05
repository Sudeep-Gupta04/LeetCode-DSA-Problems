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
    int max = 0;
    public int maxSumBST(TreeNode root) {
        HashMap<TreeNode, Integer> hm = new HashMap<>();
        preorder(root,hm);
        helpout(root,hm);
        return max;
    }
    public int preorder(TreeNode root, HashMap<TreeNode, Integer> hm){
        if(root==null) return 0;

        int val = root.val;
        int leftsum = preorder(root.left,hm);
        int rightsum = preorder(root.right,hm);

        hm.put(root,val+leftsum+rightsum);
        return val+leftsum+rightsum;
    }

    private Pair helpout(TreeNode root, HashMap<TreeNode, Integer> hm ) {
        if (root == null) {
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        if (root.left == null && root.right == null) {
            max = Math.max(max,root.val);
            return new Pair(root.val, root.val, true);
        }
        Pair lp = helpout(root.left,hm);
        Pair rp = helpout(root.right,hm);
        boolean isbst = lp.isbst && rp.isbst && (root.val > lp.max && root.val < rp.min);
        if(isbst) max = Math.max(max,hm.get(root));
        int maxval = Math.max(root.val, rp.max);
        int minval = Math.min(root.val, lp.min);

        return new Pair(maxval, minval, isbst);
    }
}
class Pair {
    int max, min;
    boolean isbst;

    Pair(int max, int min, boolean isbst) {
        this.max = max;
        this.min = min;
        this.isbst = isbst;
    }
}