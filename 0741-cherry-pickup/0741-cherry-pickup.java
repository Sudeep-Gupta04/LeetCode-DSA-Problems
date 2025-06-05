class Solution {
    int[][][] dp;
    int n, m;
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][m];
        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        int res = helper(0, 0, 0, grid);
        return Math.max(0, res);
    }

    int helper(int row1, int col1,int col2, int[][] grid) {
        int row2 = row1+col1-col2;
        if(row1>=n || row2>=n || col1>=m || col2>=m || grid[row1][col1]==-1 || grid[row2][col2]==-1) return Integer.MIN_VALUE;
        if(row1==n-1 && col1==n-1) return grid[row1][col1];
        if(dp[row1][col1][col2]!=-1) return dp[row1][col1][col2];
        int cherry;
        if(row1==row2 && col1==col2) cherry = grid[row1][col1];
        else cherry = grid[row1][col1] + grid[row2][col2];

        int func = Integer.MIN_VALUE;
        int downdown = helper(row1+1,col1,col2,grid);
        int downright = helper(row1+1,col1,col2+1,grid);
        int rightdown = helper(row1,col1+1,col2,grid);
        int rightright = helper(row1,col1+1,col2+1,grid);
        func = Math.max(Math.max(downdown,downright),Math.max(rightdown,rightright));
        return dp[row1][col1][col2] = cherry + func;
    }
}
