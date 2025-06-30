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
class P  {
        int y;
        TreeNode node;

        P(int y, TreeNode nod) {
            this.y = y;
            this.node = nod;
        }
}
class Solution {
    TreeMap<Integer,TreeMap<Integer,List<Integer>>> tm;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        this.tm = new TreeMap<>();
        Queue<P> q = new ArrayDeque<>();
        q.add(new P(0,root));
        int x =0;
        while (!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                P p = q.remove();
                TreeNode node = p.node;
                int y = p.y;
                if (!tm.containsKey(y)) {
                    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
                    List<Integer> list = new ArrayList<>();
                    list.add(node.val);
                    map.put(x, list);
                    tm.put(y, map);
                } else {
                    TreeMap<Integer, List<Integer>> map = tm.get(y);
                    map.computeIfAbsent(x, k -> new ArrayList<>()).add(node.val);
                }

                if(node.right!=null){
                    P newp = new P(y+1,node.right);
                    q.add(newp);
                }
                if(node.left!=null){
                    P newp = new P(y-1,node.left);
                    q.add(newp);
                }
            }
            x++;
        }
        
        List<List<Integer>> outer = new ArrayList<>();
        for(Map.Entry<Integer,TreeMap<Integer,List<Integer>>> i:tm.entrySet()){
            List<Integer> inner = new ArrayList<>();
            TreeMap<Integer,List<Integer>> map = i.getValue();
            for(Map.Entry<Integer,List<Integer>> j: map.entrySet()){
                List<Integer> list = j.getValue();
                Collections.sort(list);
                for(int ele:list) inner.add(ele);
            }
            outer.add(inner);
        }
        return outer;
    }
}