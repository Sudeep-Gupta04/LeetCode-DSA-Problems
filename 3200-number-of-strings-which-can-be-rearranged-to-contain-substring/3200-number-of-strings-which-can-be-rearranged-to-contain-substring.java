class Solution {
    int mod = (int)1e9+7;
    public int stringCount(int n) {
        int[][][][] dp = new int[n+1][2][3][2];
        for(int i =0;i<n+1;i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        return helper(n,0,0,0,dp);
    }
    public int helper(int n, int l, int e, int t,int[][][][] dp){
        if(n==0){
            if(l>=1 && e>=2 && t>=1) return 1;
            else return 0;
        }
        if(dp[n][l][e][t]!=-1) return dp[n][l][e][t];
        int ans = 0;
        for(int i =0;i<26;i++){
            if(i==5 && e!=2){
                ans += (helper(n-1,l,e+1,t,dp)%mod);
                ans%=mod;
            }
            else if(i==11 && l!=1){
                ans += (helper(n-1,l+1,e,t,dp)%mod);
                ans%=mod;
            }else if (i==19 && t!=1){
                ans += (helper(n-1,l,e,t+1,dp)%mod);
                ans%=mod;
            }else{
                ans += (helper(n-1,l,e,t,dp)%mod);
                ans%=mod;
            }
        }
        return dp[n][l][e][t]=ans;
    }
}