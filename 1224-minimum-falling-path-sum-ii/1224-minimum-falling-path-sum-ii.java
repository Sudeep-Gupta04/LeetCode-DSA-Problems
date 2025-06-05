class Solution {
     int dp[][];
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[n][m+1];
        for(int[] i:dp) Arrays.fill(i,-10000007);
        return helper(0,-1,grid);
    }

    private int helper(int i, int prev, int[][] grid) {
        if(i>=grid.length) return 0;
        if(dp[i][prev+1]!=-10000007) return dp[i][prev+1];
        
        int ans = Integer.MAX_VALUE;
        for(int k =0;k<grid[0].length;k++){
            if(k==prev) continue;
            ans = Math.min(ans,grid[i][k]+helper(i+1,k,grid));
        }
        return dp[i][prev+1] = ans;
    }
}