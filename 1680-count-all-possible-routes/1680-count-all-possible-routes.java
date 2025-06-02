class Solution {
    int end;
    int[][] dp;
    int n;
    int mod = (int)1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        end = finish;
        n = locations.length;
        dp = new int[n][fuel+1];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        int c = helper(start,fuel,locations);
        return (start==end)? c+1:c;
    }

    public int helper(int st,int fuel, int[] loc){
        if(fuel<0) return 0;
        if(dp[st][fuel]!=-1) return dp[st][fuel];
        int ans = 0;
        for(int i =0;i<n;i++){
            if(i==st) continue;
            if(Math.abs(loc[st]-loc[i])<=fuel){
                if(i==end) ans = (ans + 1 + helper(i,fuel-Math.abs(loc[st]-loc[i]),loc))%mod;
                else ans = (ans + helper(i,fuel-Math.abs(loc[st]-loc[i]),loc))%mod;
            }
        }
        return dp[st][fuel] = ans%mod;
    }
}