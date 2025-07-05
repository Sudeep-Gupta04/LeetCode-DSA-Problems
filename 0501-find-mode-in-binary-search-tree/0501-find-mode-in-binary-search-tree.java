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

    ArrayList<Integer> al;

    public int[] findMode(TreeNode root) {
        this.al = new ArrayList<>();
        helper(root);
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int curfreq = 1;
        int maxfreq = 1;
        //System.out.println(al);

        while (i < al.size()) {
            curfreq = 1;
            while (i < al.size() - 1 && al.get(i).equals(al.get(i + 1))) {
                curfreq++;
                i++;
            }
            if (curfreq > maxfreq) {
                //System.out.println("adding R");
                ans.clear();
                ans.add(al.get(i));
                maxfreq = curfreq;
            } else if (curfreq == maxfreq) {
                //System.out.println("adding");
                ans.add(al.get(i));
            }
            i++;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        al.add(root.val);
        helper(root.right);
    }
}
