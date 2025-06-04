class Solution {
    int[][][][] dp;
    int n;int m;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][n][m];
        for(int[][][] i:dp){
            for(int [][] j:i){
                for(int [] k:j) Arrays.fill(k,-1);
            }
        }
        return helper(0,0,0,m-1,grid);
    }
    public int helper(int row1, int col1, int row2, int col2,int[][] grid){
        if(col1<0 || col1>=m || col2<0 || col2>=m) return Integer.MIN_VALUE;
        if(row1>=n || row2>=n) return 0;
        if(dp[row1][col1][row2][col2]!=-1) return dp[row1][col1][row2][col2];
        int result = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        // int[] x = {1,1,1}; x coddnitae always++
        int[] y = {-1,0,1};
        for(int i =0;i<3;i++){
            int newr1 = row1+1; int newc1 = col1+y[i];
            for(int j = 0;j<3;j++){
                int newr2 = row2+1; int newc2 = col2+y[j];
                if(row1==row2 && col1==col2) ans = grid[row1][col1] + helper(newr1,newc1,newr2,newc2,grid);
                else ans = grid[row1][col1] + grid[row2][col2] +  helper(newr1,newc1,newr2,newc2,grid);
                result = Math.max(ans,result);
            }
        }
        return dp[row1][col1][row2][col2] = result;
    }
}