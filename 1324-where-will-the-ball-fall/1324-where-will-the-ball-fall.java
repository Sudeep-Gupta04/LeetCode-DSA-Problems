class Solution {
    int[][] dp;
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        dp = new int[n][m];
        for(int[] i:dp) Arrays.fill(i,-2);
        for(int i =0;i<m;i++){
            if(dp[0][i]==-2){
                int v = helper(0,i,grid,n,m);
                ans[i] = (v!=-2)?v:-1;
            }else{
                ans[i] = dp[0][i];
            }
        }
        return ans;
    }

    public int helper(int i, int j, int[][] grid, int n, int m){
        if(i>=n) return j;
        if(dp[i][j]!=-2) return dp[i][j];
        int p1 = -1;
        int p2 = -1;
        if(grid[i][j]==1 && j<m-1 && grid[i][j+1]==grid[i][j]){
            p1 = helper(i+1,j+1,grid,n,m);
        }else if(grid[i][j]==-1 && j>0 && grid[i][j-1]==grid[i][j]){
            p2 = helper(i+1,j-1,grid,n,m);
        }
        if(p1!=-1) return dp[i][j] = p1;
        else if(p2!=-1) return dp[i][j] = p2;
        else return dp[i][j] = -1;
    }
}