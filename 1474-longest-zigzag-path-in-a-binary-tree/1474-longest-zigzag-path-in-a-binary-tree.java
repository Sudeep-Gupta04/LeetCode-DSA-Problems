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
// class ele{
//     TreeNode t;
//     int l; int r;
//     ele(t,l,r){
//         this.t = t;
//         this.r = r;
//         this.l = l;
//     }
    
// }
class Solution {
    HashMap<String,Integer> hm = new HashMap<>();
    public int longestZigZag(TreeNode root) {
        return inorder(root);
    }
    public int inorder(TreeNode root){
        if(root==null) return 0;
        
        int ans = longest(root,0);
        int ansl = inorder(root.left);
        int ansr = inorder(root.right);

        return Math.max(ans,Math.max(ansl,ansr));
    }   
    // prv =0 means no prv, prv=1 coming from left, prv = 2 coming form right;
    public int longest(TreeNode root,int prv){
        if(root==null) return -1;
        String key= root + ","+prv;
        if(hm.containsKey(key)) return hm.get(key);
        int p1 =0; int p2 =0;
        if(prv==0){
             p1 = 1 + longest(root.right,2);
             p2 = 1 + longest(root.left,1);
        }
        else if(prv ==1){
             p1 = 1 + longest(root.right,2);
        }else{
             p1 = 1 + longest(root.left,1);
        }
        hm.put(key,Math.max(p1,p2));
        return Math.max(p1,p2);
    }
}