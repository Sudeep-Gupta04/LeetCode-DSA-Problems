/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    if (root == null) return "-1001";

    ArrayList<Integer> al = new ArrayList<>();
    Queue<TreeNode> q = new ArrayDeque<>();
    q.add(root);

     while (!q.isEmpty()) {
        TreeNode node = q.remove();
        al.add(node.val);
        if (node.val != -1001) {
            if (node.left != null) q.add(node.left);
            else q.add(new TreeNode(-1001)); 

            if (node.right != null) q.add(node.right);
            else q.add(new TreeNode(-1001));
        }
    }

    String str = "";
    for (int i = 0; i < al.size(); i++) {
        str += al.get(i) + " ";
    }

    return str;
}



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("-1001")) return null;

        ArrayList<TreeNode> vals = new ArrayList<>();
        int i = 0;
        boolean isNeg = false;

        while (i < data.length()) {
            int num = 0;
            if (data.charAt(i) == '-') {
                isNeg = true;
                i++;
            } else {
                isNeg = false;
            }

            while (i < data.length() && data.charAt(i) != ' ') {
                num = num * 10 + (data.charAt(i) - '0');
                i++;
            }
            if (isNeg) num = -num;

            if(num==-1001) vals.add(null);
            else vals.add(new TreeNode(num));

            i++; 
        }
        // for(int j =0;j<vals.size();j++){
        //     System.out.print(((vals.get(j)==null)?"N ":vals.get(j).val)+" ");
        // }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(vals.get(0));
        i = 1;
        while(!q.isEmpty()){
            int size = 2*q.size();
            int j = i;
            for(;j<(Math.min(vals.size(),i+size));j=j+2){
                TreeNode nd = q.remove();
                nd.left = vals.get(j);
                nd.right = vals.get(j+1);

                if(nd.left!=null) q.add(nd.left);
                if(nd.right!=null) q.add(nd.right);
            }
            i = j;
        }
        return vals.get(0);
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));