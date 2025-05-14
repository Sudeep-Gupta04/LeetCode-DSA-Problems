class Solution {
   public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i =0;i<n;i++)al.add(new ArrayList<>());
        for(int i =0;i<edges.length;i++){
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] vis = new boolean[n];
        dfs(vis,al,source,destination);
        return vis[destination];
    }

    public void dfs(boolean[] vis, ArrayList<ArrayList<Integer>> al , int src , int des){
        vis[src] = true;
        for(int i:al.get(src)){
            if(!vis[i]){
                dfs(vis,al,i,des);
            }
        }
    }
}