class Solution {
    public int maxMoves(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            ans = Math.max(ans, findMoves(grid, i, 0, dp));
        }
        return ans;
    }
    // private int findMoves(int[][] grid, int i,int j, int[][] dp) {
    //     if(j==dp[i].length-1) {
    //         dp[i][j] =0;
    //         return 0;
    //     }

    //     if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int c;
    //     if(i-1>=0 && j+1<dp.length && grid[i-1][j+1]>grid[i][j]) {
    //         c = 1 + findMoves(grid,i-1,j+1,dp);
    //         dp[i][j] = Math.max(c,dp[i][j]);
    //     }
    //     if(j+1<dp.length && grid[i][j+1]>grid[i][j]) {
    //         c = 1 + findMoves(grid,i,j+1,dp);
    //         dp[i][j] = Math.max(c,dp[i][j]);
    //     }
    //     if(i+1<dp.length && j+1<dp.length && grid[i+1][j+1]>grid[i][j]) {
    //         c = 1 + findMoves(grid,i+1,j+1,dp);
    //         dp[i][j] = Math.max(c,dp[i][j]);
    //     }
    //     return dp[i][j];
    // }

    private int findMoves(int[][] grid, int i, int j, int[][] dp) {
        if (j == grid[0].length - 1) {
            dp[i][j] = 0;
            return 0;
        }
        
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int max = 0;
        if (i - 1 >= 0 && j + 1 < grid[0].length && grid[i - 1][j + 1] > grid[i][j]) {
            int c = 1 + findMoves(grid, i - 1, j + 1, dp);
            max = Math.max(max, c);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] > grid[i][j]) {
            int c = 1 + findMoves(grid, i, j + 1, dp);
            max = Math.max(max, c);
        }
        if (i + 1 < grid.length && j + 1 < grid[0].length && grid[i + 1][j + 1] > grid[i][j]) {
            int c = 1 + findMoves(grid, i + 1, j + 1, dp);
            max = Math.max(max, c);
        }

        dp[i][j] = max;
        return dp[i][j];
    }
}
