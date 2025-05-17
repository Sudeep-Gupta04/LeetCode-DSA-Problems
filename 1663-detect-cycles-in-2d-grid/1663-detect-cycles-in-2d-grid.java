class Solution {
   boolean ans = false;
    public boolean containsCycle(char[][] grid) {
        ans = false;
        int n = grid.length;
        int m =grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] x = {-1,0,1,0};
        int[] y = {0,1,0,-1};
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(ans) return ans;
                if(!vis[i][j]){
                    dfs(grid,i,j,x,y,vis,-1,-1);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] grid,int i,int j,int[] x,int[] y,boolean[][]vis,int px, int py){
        if(ans) return;
        vis[i][j] = true;
        for(int k =0;k<4;k++){
            int newx = i + x[k];
            int newy = j + y[k];
            if(newx>=0 && newy>=0 && newx<vis.length && newy<vis[0].length && grid[i][j]==grid[newx][newy]){
                if(vis[newx][newy] && !(px==newx && newy==py)){  
                    ans = true;  
                }else if(!vis[newx][newy]){
                    dfs(grid,newx,newy,x,y,vis,i,j);
                }
            }
        }
    }
}