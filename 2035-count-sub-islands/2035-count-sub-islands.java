class Solution {
    boolean c = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
        boolean[][] vis = new boolean[n][m];
        int ct =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j]  && grid2[i][j]==1){
                    dfs(grid1,grid2,i,j,vis,n,m);
                    if(c) ct++;
                    c = true;
                }
            }
        }
        return ct;
    }
    void dfs(int[][] grid1,int[][] grid2, int i, int j,boolean[][] vis,int n, int m){
        if(grid1[i][j]==0){
            c = false;
            return;
        }
        vis[i][j] = true;
        int x[] = {-1, 0, 1, 0};
        int y[] = {0, 1, 0, -1};

        for (int k = 0; k < 4; ++k) {
            int newx = i + x[k];
            int newy = j + y[k];
            if (newx >= 0 && newx < n && newy >= 0 && newy < m && !vis[newx][newy] && grid2[newx][newy] == 1) {
                dfs(grid1,grid2,newx,newy,vis,n,m);
            }
        }
    }
}