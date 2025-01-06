class Solution {
    int c =0;
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    dfs(grid,vis,i,j);
                    ans = Math.max(ans,c);
                    c = 0;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid, boolean[][] vis, int i, int j) {
    c++;
    vis[i][j] = true;
    int[] x = {0, +1, 0, -1};
    int[] y = {-1, 0, +1, 0};
    
    for (int k = 0; k < 4; k++) {
        int newx = i + x[k];
        int newy = j + y[k];
        
        if (newx >= 0 && newy >= 0 && newx < vis.length && newy < vis[0].length && !vis[newx][newy] && grid[newx][newy] == 1) {
            dfs(grid, vis, newx, newy);
        }
    }
}
}