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
        public int minimumOperations(TreeNode root) {
        List<List<Integer>> outer = new ArrayList<>();
        if (root == null) return 0; // ✅ fix: match return type

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> internal = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode root1 = q.remove();
                internal.add(root1.val);
                if (root1.left != null) q.add(root1.left);
                if (root1.right != null) q.add(root1.right);
            }
            outer.add(internal);
        }

        int c = 0;
        for (int i = 0; i < outer.size(); i++) {
            List<Integer> inner = outer.get(i);
            List<Integer> copy = new ArrayList<>(inner);
            Collections.sort(copy);
            HashMap<Integer, Integer> hm = new HashMap<>();
            for (int j = 0; j < inner.size(); j++) {
                hm.put(inner.get(j), j);
            }
            for (int j = 0; j < inner.size(); j++) {
                if (inner.get(j)!=copy.get(j)) { 
                    c++;
                    int actidx = hm.get(copy.get(j));
                    hm.put(inner.get(j), actidx); 
                    hm.put(copy.get(j), j);
                    int temp = inner.get(actidx);
                    inner.set(actidx, inner.get(j));
                    inner.set(j, temp);
                }
            }
        }
        return c;
    }
}