class Solution {
     public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i =0;i<n;i++){
            al.add(new ArrayList<>());
            al.get(i).add(i+1);
        }

        int[] ans = new int[queries.length];
        for(int i =0;i<queries.length;i++){
            al.get(queries[i][0]).add(queries[i][1]);
            ans[i] = BFS(al,n,0);
        }
        return ans;
    }

    private int BFS(ArrayList<ArrayList<Integer>> al, int n, int sr) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        vis[sr] = true;
        q.add(sr);
        int ans =0;
        while (!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int node = q.remove();
            if(node==n-1) return ans;
            else{
                for(int Node:al.get(node)){
                   if(!vis[Node]){
                       if(Node==n-1) return ans+1;
                       vis[Node] = true;
                       q.add(Node);
                   }
                }
                }
            }
            ans++;
        }
        return ans;
    }

}