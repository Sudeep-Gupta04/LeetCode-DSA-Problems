class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer,HashSet<Integer>> colour = new HashMap<>();
        HashMap<Integer,Integer> filled= new HashMap<>();
        int[] ans = new int[queries.length];
        for(int i =0;i<queries.length;i++){
            int col = queries[i][1];
            int node = queries[i][0];
            if(!filled.containsKey(node)){
                filled.put(node,col);
                HashSet<Integer> set = colour.getOrDefault(col, new HashSet<>());
                set.add(node);
                colour.put(col, set);
            }else{
                int oldcol = filled.get(node);
                filled.put(node,col);
                HashSet<Integer> set = colour.get(oldcol);
                set.remove(node);
                if(!set.isEmpty()){
                    colour.put(oldcol,set);
                }else{
                    colour.remove(oldcol);
                }
                System.out.println(colour.size());
                HashSet<Integer> sett = colour.getOrDefault(col, new HashSet<>());
                sett.add(node);
                colour.put(col, sett);
            }
            ans[i] = colour.size();
        }
        return ans;
    }
}