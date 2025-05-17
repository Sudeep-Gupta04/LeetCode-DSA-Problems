class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dis = new int[n][n];
        for(int i =0;i<n;i++){
            Arrays.fill(dis[i],10000);
            bfs(i,dis,graph);
        }
        int[][] dp = new int[n+1][(int) Math.pow(2,n)];
        for(int i =0;i<n+1;i++) Arrays.fill(dp[i],-1);
        return solve(-1,0,dp,dis,n);
    }
    public int solve(int pre , int bitmask, int[][] dp , int[][] dis,int n){
        if(bitmask == ((1<<n)-1)) return 0;
        if(dp[pre+1][bitmask]!=-1) return dp[pre+1][bitmask];

        int ans = 100000;
        for(int i =0;i<n;i++){
            if((bitmask & (1<<i))==0){
                int predis;
                if(pre==-1) predis = 0;
                else predis = dis[pre][i];
                ans = Math.min(ans,predis + solve(i,(bitmask | (1<<i)),dp,dis,n));
            }
        }
        return dp[pre+1][bitmask] = ans;
    }
    public void bfs(int src, int[][] dis, int[][] graph){
        boolean[] vis = new boolean[dis.length];
        vis[src] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        int c = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int nod = q.remove();
                if(dis[src][nod]>c) dis[src][nod] = c;
                for(int j:graph[nod]){
                    if(!vis[j]){
                        q.add(j);
                        vis[j] = true;
                    }
                }
            }
            c++;
        }
    }
}