class Solution {
        public int countPaths(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int mod = (int)1e9 + 7;

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        int[] x ={-1,0,1,0};
        int[] y ={0,1,0,-1};
        int[][] indeg = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                for(int k=0;k<4;k++){
                    int newx = i + x[k];
                    int newy = j + y[k];
                    if(newx>=0 && newy>=0 && newx<n && newy<m && grid[newx][newy]>grid[i][j]){
                        indeg[newx][newy]++;
                    }
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(indeg[i][j]==0) q.add(new int[]{i,j});
            }
        }
        int lv =1;
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] nod = q.remove();
                for(int k=0;k<4;k++){
                    int newx = nod[0] + x[k];
                    int newy = nod[1] + y[k];
                    if(newx>=0 && newy>=0 && newx<n && newy<m && grid[newx][newy]>grid[nod[0]][nod[1]]){
                        dp[newx][newy] += ((dp[nod[0]][nod[1]] + 1) % mod);
                        //ans %= mod;
                        indeg[newx][newy]-=1;
                        if(indeg[newx][newy]==0) q.add(new int[]{newx,newy});
                    }
                }
            }
            lv++;
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                ans+=(dp[i][j]%mod);
                ans%=mod;
            }
        }
        return ans + (m*n);
    }
}