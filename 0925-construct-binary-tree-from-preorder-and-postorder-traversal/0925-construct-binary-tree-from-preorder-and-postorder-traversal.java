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
    HashMap<Integer,Integer> pre;
    HashMap<Integer,Integer> post;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.pre = new HashMap<>();
        this.post = new HashMap<>();
        int n = preorder.length;
        for(int i =0;i<n;i++){
            pre.put(preorder[i],i);
            post.put(postorder[i],i);
        }
        return helper(0,n-1,0,n-1,preorder,postorder);
    }

    
    public TreeNode helper(int pres, int pree, int posts, int poste, int[] preorder, int[] postorder) {
        if (pres > pree || posts > poste) return null;

        TreeNode root = new TreeNode(preorder[pres]);
        if (pres == pree) return root;
        int leftVal = preorder[pres + 1];
        int postidx = post.get(leftVal);
        int leftSize = postidx - posts + 1;
        root.left = helper(pres+1, pres+leftSize, posts, postidx, preorder, postorder);
        root.right = helper(pres+leftSize + 1, pree, postidx+1, poste-1, preorder, postorder);

        return root;
    }
}