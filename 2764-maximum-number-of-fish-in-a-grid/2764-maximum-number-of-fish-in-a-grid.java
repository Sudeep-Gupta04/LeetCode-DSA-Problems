class Solution {
    public int findMaxFish(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int ans = Integer.MIN_VALUE;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]!=0 && !vis[i][j]){
                    ans = Math.max(ans,Dfs(i,j,grid,vis));
                }
            }
        }
        return (ans<0)?0:ans;
    }
    public int Dfs(int i, int j, int[][] grid, boolean[][] vis){
        vis[i][j] = true;
        int[] x = {0,1,0,-1};
        int[] y = {1,0,-1,0};
        int ans = grid[i][j];
        for(int k =0;k<4;k++){
            int newx = i+x[k];
            int newy = j+y[k];
            if(newx>=0 && newy>=0 && newx<grid.length && newy<grid[0].length && grid[newx][newy]!=0 && !vis[newx][newy]){
                ans += Dfs(newx,newy,grid,vis);
            }
        }
        return ans;
    }
}