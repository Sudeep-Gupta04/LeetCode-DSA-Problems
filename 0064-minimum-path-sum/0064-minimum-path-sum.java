class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(0,0,n,m,grid);
    }
    public int helper(int i, int j,int n, int m,int[][] grid){
        if(i==n-1 && j==m-1) return grid[i][j];
        if(i>=n || j>=m) return 1000000;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j] = Math.min(grid[i][j] + helper(i+1,j,n,m,grid),grid[i][j] + helper(i,j+1,n,m,grid));
    }
}