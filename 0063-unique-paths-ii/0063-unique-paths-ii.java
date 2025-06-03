class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        dp = new int[n][m];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(0,0,n,m,obstacleGrid);
    }
    public int helper(int i, int j,int n, int m,int[][] grid){
        
        if(i>=n || j>=m || grid[i][j]==1) return 0;
        if(i==n-1 && j==m-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j] = helper(i+1,j,n,m,grid) + helper(i,j+1,n,m,grid);
    }
}