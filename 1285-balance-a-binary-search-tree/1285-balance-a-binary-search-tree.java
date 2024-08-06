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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> al  = new ArrayList<>();
        inorderTraversal(al,root);
       // Collections.sort(al);

    TreeNode node = creatBSTFromSortedArray(al,0,al.size()-1);
    return node;
    }
    private TreeNode creatBSTFromSortedArray(ArrayList<Integer> al, int start, int end) {
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(al.get(mid));
        node.left = creatBSTFromSortedArray(al,start,mid-1);
        node.right = creatBSTFromSortedArray(al,mid+1,end);
        return node;
    }

    private void inorderTraversal(ArrayList<Integer> al, TreeNode root) {
        if(root==null) return;

        inorderTraversal(al,root.left);
        al.add(root.val);
        inorderTraversal(al,root.right);
    }
}