class Solution {
    int[][][] dp;
    int mod = (int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove+1];
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        } 
        return solve(startRow,startColumn,m,n,maxMove);
    }
    public int solve(int i, int j,int m,int n, int k){
        if(k==0 && i<m && i>=0 && j<n && j>=0) return 0;
        if(i>=m || i<0 || j>=n || j<0) return 1;
        if(dp[i][j][k]!=-1) return dp[i][j][k];
        int ans = 0;
        return dp[i][j][k] = ((((ans + solve(i+1,j,m,n,k-1))%mod + solve(i-1,j,m,n,k-1))%mod + solve(i,j-1,m,n,k-1))%mod + solve(i,j+1,m,n,k-1))%mod;
    }
}