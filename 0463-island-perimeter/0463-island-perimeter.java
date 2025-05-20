class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;;
        int m = grid[0].length;
        int ans = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    ans = dfs(i,j,vis,grid,n,m);
                }
            }
        }
        return ans;
    }

    public int dfs(int i, int j,boolean[][] vis, int[][] grid,int n, int m){
        vis[i][j] = true;
        int[] x ={-1,0,1,0};
        int[] y ={0,1,0,-1};
        int ans = 4;
        for(int k=0;k<4;k++){
            int newx = i + x[k];
            int newy = j+ y[k];
            if(newx>=0 && newx<n && newy>=0 && newy<m && grid[newx][newy]==1){
                if(vis[newx][newy]) ans--;
                else  ans += (dfs(newx,newy,vis,grid,n,m)-1);               
            }
        }
        return ans;
    }
}