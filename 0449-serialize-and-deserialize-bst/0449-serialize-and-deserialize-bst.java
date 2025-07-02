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
        String str = preorder(root,new StringBuilder("")).toString();
        System.out.println(str.substring(0,str.length()-1));
        return str.substring(0,str.length()-1);
    }

    private StringBuilder preorder(TreeNode root,StringBuilder sb) {
        if(root==null) {
            return sb.append("N").append(",");
        }

        sb.append(root.val+"").append(",");
        preorder(root.left,sb);
        preorder(root.right,sb);
        return sb;
    }

    int i =0;
    public TreeNode deserialize(String data) {
        
        String[] arr = data.split(",");
        return createTree(arr);
    }

    public TreeNode createTree(String[] arr){
        if (i >= arr.length || arr[i].equals("N")) {
            i++;
            return null;
        }
        TreeNode n = new TreeNode(Integer.parseInt(arr[i++]));
        n.left = createTree(arr);
        n.right = createTree(arr);
        return n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;