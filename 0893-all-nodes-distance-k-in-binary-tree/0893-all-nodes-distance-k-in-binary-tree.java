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
    static List<Integer> ans;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.ans = new ArrayList<>();
        if(k==0){
            ans.add(target.val);
            return ans;
        }
        ArrayList<TreeNode> al = helper(root,target);
        Collections.reverse(al);
        TreeNode temp = al.get(al.size()-1);
        bfs(temp, k);
        temp.right = null; temp.left = null;

        for(int i = al.size()-2;i>=0;i--){
            TreeNode par = al.get(i);
            TreeNode child = al.get(i+1);

            if(child.left==null) child.left=par;
            else child.right=par;

            if(par.left==child) par.left = null;
            else par.right = null;
        }

        bfs(al.get(al.size()-1),k);
        return ans;
    }

    public static int bfs(TreeNode node,int k){
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(node);
        int lv =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){

                TreeNode nd = q.remove();
                if(lv==k) ans.add(nd.val);

                if(nd.left!=null) q.add(nd.left);
                if(nd.right!=null) q.add(nd.right);
            }
            lv++;
        }
        return lv;
    }

    public static ArrayList<TreeNode> helper(TreeNode root,TreeNode tar){
        if(root==null) return null;

        if(root==tar){
            ArrayList<TreeNode> al = new ArrayList<>(); al.add(root);
            return al;
        }

        ArrayList<TreeNode> alleft  =  helper(root.left,tar);
        ArrayList<TreeNode> alright =  helper(root.right,tar);

        if(alleft==null && alright!=null){
            alright.add(root);
            return alright;
        }else if(alleft!=null && alright==null){
            alleft.add(root);
            return alleft;
        }else{
            return null;
        }
    }
}