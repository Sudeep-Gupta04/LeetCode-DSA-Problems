class Solution {
        static public void solve(char[][] board) {
        boolean[][] vis = new boolean[board.length][board[0].length];
        for(int i =0;i<board.length;i++){
            if(board[i][0]=='O' && !vis[i][0]) BFStraversal(i,0,vis,board);
        }
        for(int i =0;i<board.length;i++){
            if(board[i][board[0].length-1]=='O' && !vis[i][board[0].length-1]) BFStraversal(i,board[0].length-1,vis,board);
        }
        for(int j =0;j<board[0].length;j++){
            if(board[0][j]=='O' && !vis[0][j]) BFStraversal(0,j,vis,board);
        }
        for(int j =0;j<board[0].length;j++){
            if(board[board.length-1][j]=='O' && !vis[board.length-1][j]) BFStraversal(board.length-1,j,vis,board);
        }
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X'; 
                }
            }
        }
    }
    static private void BFStraversal(int i, int j, boolean[][] vis, char[][] board) {
        vis[i][j] = true;
        int [] row = {-1,0,1,0};
        int [] col = {0,1,0,-1};
        for(int k =0;k<row.length;k++){
            int x = i+row[k];
            int y = j+col[k];
            if(x>=0 && x<vis.length && y>=0 && y<board[0].length && !vis[x][y] && board[x][y]=='O'){
                BFStraversal(x,y,vis,board);
            }
        }
    }
}