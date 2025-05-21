class Solution {
    boolean[][] vis;
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new boolean[n][m];
        for(int i =0;i<n;i++){
           if(grid[i][0]==0 && !vis[i][0]){
               dfs(grid,i,0,n,m);
           }
           if(grid[i][m-1]==0 && !vis[i][m-1]){
               dfs(grid,i,m-1,n,m);
           }
        }   
        for(int j =0;j<m;j++){
           if(grid[0][j]==0 && !vis[0][j]){
               dfs(grid,0,j,n,m);
           }
           if(grid[n-1][j]==0 && !vis[n-1][j]){
               dfs(grid,n-1,j,n,m);
           }
        }  
        int c = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j] && grid[i][j]==0){
                    c++;
                    dfs(grid,i,j,n,m);
                }
            }
        } 
        return c;
    }
    private void dfs(int[][] land, int i, int j, int n, int m) {
        vis[i][j] = true;
        int x[] = {-1, 0, 1, 0};
        int y[] = {0, 1, 0, -1};

        for(int k=0;k<4;k++){
            int newx = i + x[k];
            int newy = j + y[k];
            if (newx >= 0 && newx < n && newy >= 0 && newy < m && !vis[newx][newy] && land[newx][newy] == 0) {
                dfs(land,newx,newy,n,m);
            }
        }
        return;
    }
}