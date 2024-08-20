class Solution {
    public List<List<String>> solveNQueens(int n) {

        int[][] bord = new int[n][n];
        List<List<String>> al = new ArrayList<>();
        solve(0,bord,al);
        return al;
    }

    private void solve(int row,int[][] bord, List<List<String>> al) {
        if(row==bord.length){
            List<String> ans = new ArrayList<>();
            for(int i =0;i<bord.length;i++){
                String s ="";
                for(int j = 0;j<bord.length;j++){
                    if(bord[i][j]==1){
                        s = s + "Q";
                    }else {
                        s = s+".";
                    }
                }
                ans.add(s);
            }
            al.add(ans);
            return;
        }

        for(int i =0;i<bord.length;i++){
            if(isSafe(row,i,bord)){
                bord[row][i] = 1;
                solve(row+1,bord,al);
                bord[row][i] = 0;
            }
        }
    }

    private boolean isSafe(int r,int i, int[][] bord) {
        // up
        for(int row =0;row<r;row++){
            if(bord[row][i]==1) return false;
        }
        //left
        for(int col =0;col<i;col++){
            if(bord[r][col]==1) return false;
        }
        int row = r;
        int col = i;
        while (r-1 >= 0 && i+1<bord.length){
            if(bord[r-1][i+1]==1) return false;
            r--;i++;
        }
        while (row-1 >= 0 && col-1>=0){
            if(bord[row-1][col-1]==1) return false;
            row--;col--;
        }
        return true;
    }
}