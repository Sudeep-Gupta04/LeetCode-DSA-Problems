class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int c =0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i =0;i<hasApple.size();i++){
            if(hasApple.get(i))  hs.add(i);
        }
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i =0;i<n;i++) al.add(new ArrayList<Integer>());
        for(int[] i:edges){
            al.get(i[0]).add(i[1]);
            al.get(i[1]).add(i[0]);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();
        return dfs(0,vis,al,hs);
    }
    int dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> al,HashSet<Integer> hs){
        int dis = 0;
        int ans = 0;
        vis[node]= true;
        for(int i:al.get(node)){
            if(!vis[i]){
               int childAns = dfs(i,vis,al,hs);
                if(childAns>0 || hs.contains(i)){
                    ans+=(childAns+2);
                }
            }
        }
        return ans;
    }
}