class Solution {
        public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        int c =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j]  && board[i][j]=='X'){
                    c++;
                    dfs(board,i,j,vis,n,m);
                }
            }
        }
        return c;
    }
    void dfs(char[][] grid, int i, int j,boolean[][] vis,int n, int m){
        vis[i][j] = true;
        int x[] = {-1, 0, 1, 0};
        int y[] = {0, 1, 0, -1};

        for (int k = 0; k < 4; ++k) {
            int newx = i + x[k];
            int newy = j + y[k];
            if (newx >= 0 && newx < n && newy >= 0 && newy < m && !vis[newx][newy] && grid[newx][newy] == 'X') {
                dfs(grid,newx,newy,vis,n,m);
            }
        }
    }
}