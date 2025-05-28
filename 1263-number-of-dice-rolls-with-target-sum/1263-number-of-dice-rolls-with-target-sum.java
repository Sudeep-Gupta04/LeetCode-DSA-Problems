class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = (int)1e9+7;
        int[][] dp = new int[n+1][target+1];
        for(int i =0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n,k,target,dp,mod);
    }
    public int helper(int n, int k, int target, int[][] dp,int mod){
        if(n==1){
                if(target<=k) return 1;
                else return 0;
        }
            if(dp[n][target]!=-1) return dp[n][target];
            int ans = 0;
            for(int i =1;i<=k;i++){
                if(target-i>0){
                    
                    ans+=(helper(n-1,k,target-i,dp,mod));
                    ans %= mod;
                }
            }
        return dp[n][target] = ans;
    }

}