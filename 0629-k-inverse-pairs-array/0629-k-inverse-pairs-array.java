class Solution {
    public int kInversePairs(int n, int k) {
        int mod = (int)1e9+7;
        int[][] dp = new int[n+1][k+1];
        for(int i =0;i<n+1;i++){
            dp[i][0] = 1;
        }
        dp[0][0] = 0;
        for(int i =1;i<=n;i++){
            int prevsum = 1;
            for(int j = 1;j<=Math.min(k,(i*(i-1))/2);j++){
                prevsum += (dp[i-1][j]%mod);
                prevsum %= mod;
                if(j-i>=0) prevsum = (prevsum - dp[i - 1][j - i] + mod) % mod;
                dp[i][j] = prevsum;
            }
        }
        return dp[n][k];
    }
}