class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] bt = new boolean[board.length][board[0].length];
        for(int i =0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(check(board,word,i,j,0,bt)) return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, String word,int i,int j,int idx,boolean[][] bt) {
        if(idx==word.length())return true;
        if(i>=board.length || j>=board[0].length || i<0 || j<0) return false;
        if(board[i][j]!=word.charAt(idx)) return false;
        boolean ans=false;
        if(board[i][j]==word.charAt(idx) && !bt[i][j]){
            bt[i][j]=true;
            ans =  check(board,word,i-1,j,idx+1,bt)||check(board,word,i,j+1,idx+1,bt) || check(board,word,i+1,j,idx+1,bt) || check(board,word,i,j-1,idx+1,bt);
            bt[i][j]=false;
        }
        return ans;
    }
}