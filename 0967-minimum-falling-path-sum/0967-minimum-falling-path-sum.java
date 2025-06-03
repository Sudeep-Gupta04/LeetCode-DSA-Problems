class Solution {
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        dp = new int[n][m];
        for(int []i:dp) Arrays.fill(i,-500001);
        int ans = Integer.MAX_VALUE;
        for(int i =0;i<m;i++){
            ans = Math.min(ans,helper(0,i,matrix,n,m));
        }
        return ans;
    }
    public int helper(int i, int j,int[][] grid,int n,int m){
        if(j<0 || j>=m) return 1000000;
        if(i==n-1) return grid[i][j];
        if(dp[i][j]!=-500001) return dp[i][j];
        return dp[i][j] = Math.min(grid[i][j] + helper(i+1,j,grid,n,m),
                        Math.min(grid[i][j] + helper(i+1,j-1,grid,n,m),
                        grid[i][j] + helper(i+1,j+1,grid,n,m)));
    }

}