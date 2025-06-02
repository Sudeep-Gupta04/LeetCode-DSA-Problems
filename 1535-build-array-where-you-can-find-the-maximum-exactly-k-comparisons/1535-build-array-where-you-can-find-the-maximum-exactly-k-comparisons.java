class Solution {
    int mod = (int)1e9+7;
    int[][][] dp;
    public int numOfArrays(int n, int m, int k) {
        dp = new int[n+1][m+2][k+1];
        for(int i =0;i<n+1;i++){
            for(int j =0;j<m+2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(n,-1,k,m);
    }
    public int helper(int n,int preval,int k,int m){
        if(n==0 && k==0) return 1;
        if(n<0 || k<0) return 0;
        if(dp[n][preval+1][k]!=-1) return dp[n][preval+1][k];
        int ans = 0;
        for(int i =1;i<=m;i++){
            if(i>preval){
                ans = (ans + helper(n-1,i,k-1,m))%mod;
            }else {
                ans = (ans + helper(n-1,preval,k,m))%mod;
            }
        }
        return dp[n][preval+1][k] = ans%mod;
    }
}