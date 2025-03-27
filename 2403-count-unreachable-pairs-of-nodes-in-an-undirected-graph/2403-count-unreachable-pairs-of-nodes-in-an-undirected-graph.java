class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i =0;i<n;i++) al.add(new ArrayList<>());
        for(int i =0;i<edges.length;i++){
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] vis = new boolean[n];
        ArrayList<Integer> pa = new ArrayList<>();
        long sum = 0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                int num = dfs(i,vis,al);
                sum += num;
                pa.add(num);
            }
        }
        long ans = 0;
        for(int i =1;i<pa.size();i++){
            sum -= pa.get(i);
            ans += pa.get(i)*sum;
        }
        return ans;
    }
    public int dfs(int node, boolean[] vis,ArrayList<ArrayList<Integer>> al){
        vis[node] = true;
        int c = 1;
        for(int i:al.get(node)){
            if(!vis[i]){
                c = c + dfs(i,vis,al);
            }
        }
        return c;
    }
}