class Solution {
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        dp = new int[n][m];
        for(int[] i:dp) Arrays.fill(i,-1000000);
        int ans = helper(0,0,dungeon,n,m);
        return (ans==0)?1:ans;
    }
    public int helper(int i, int j,int[][]grid,int n, int m){
        if(i==n-1 && j==m-1){
            return dp[i][j] = (grid[i][j]<=0)?-1*grid[i][j]+1:0;
        }
        if(dp[i][j]!=-1000000) return dp[i][j];
        int p1 = Integer.MAX_VALUE; int p2 = Integer.MAX_VALUE;
        if(grid[i][j]>0){
            if(i<n-1) p1 = -grid[i][j] + helper(i+1,j,grid,n,m);
            if(j<m-1) p2 = -grid[i][j] + helper(i,j+1,grid,n,m);
            int min = Math.min(p1,p2);
            if(min<0) return dp[i][j]= 0;
            else return dp[i][j] = min;
        }else{
            if(i<n-1) p1 = -1*grid[i][j] + ((helper(i+1,j,grid,n,m)==0)?1:helper(i+1,j,grid,n,m));
            if(j<m-1) p2 = -1*grid[i][j] + ((helper(i,j+1,grid,n,m)==0)?1:helper(i,j+1,grid,n,m));
            return dp[i][j] = Math.min(p1,p2);
        }
    }
}