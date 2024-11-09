class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i =0;i<grid.length;i++){
            if(grid[i][0]==1) DFS(i,0,grid);
        }
        for(int i =0;i<grid.length;i++){
            if(grid[i][grid[0].length-1]==1 ) DFS(i,grid[0].length-1,grid);
        }
        for(int j =0;j<grid[0].length;j++){
            if(grid[0][j]==1) DFS(0,j,grid);
        }
        for(int j =0;j<grid[0].length;j++){
            if(grid[grid.length-1][j]==1) DFS(grid.length-1,j,grid);
        }
        int c =0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==1) c++;
            }
        }
        return c;
    }

    private void DFS(int i, int j, int[][] grid) {
        grid[i][j] = 0;
        int [] row = {-1,0,1,0};
        int [] col = {0,1,0,-1};
        for(int k =0;k<row.length;k++){
            int x = i+row[k];
            int y = j+col[k];
            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1){
               DFS(x,y,grid);
            }
        }
    }

}