class Solution {
    public static int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for(int i =0;i<stones.length;i++){
            sum += stones[i];
        }
        int[][] dp = new int[n][sum+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        dp[0][stones[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < sum+1; j++) {
                if(dp[i-1][j]==1 || (j>=stones[i] && dp[i-1][j-stones[i]]==1)) dp[i][j] = 1;
                else dp[i][j] = 0;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i =0;i<sum+1;i++){
            if(dp[n-1][i]==1){
                ans = Math.min(ans,Math.abs(i-(sum-i)));
            }
        }
        return ans;
    }
    public static int helper(int i, int tar,int[][] dp, int[] stones){
        if(i>=stones.length && tar==0) return 1;
        if(i>=stones.length) return 0;
        if(dp[i][tar]!=-1) return dp[i][tar];
        int ntake = helper(i+1,tar,dp,stones);
        int take = 0;
        if(tar>=stones[i]) take = helper(i+1,tar-stones[i],dp,stones);
        if(take==1 || ntake==1) return dp[i][tar] = 1;
        else return dp[i][tar] = 0;
    }
}