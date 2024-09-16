class Solution {
    public long maxScore(int[] a, int[] b) {
        long[][] dp = new long[b.length][4];
        for(int i =0;i<dp.length;i++){
            for(int j =0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return helper(a,b,0,0,dp);
    }

    private long helper(int[] a, int[] b, int pick, int i ,long[][] dp) {
        if(pick==4) return 0;
        if(i>=b.length) return Integer.MIN_VALUE;
        if(dp[i][pick]!=-1) return dp[i][pick];
        
        long take = (long) a[pick] *b[i] + helper(a,b,pick+1,i+1, dp);
       
        long ntake = helper(a,b,pick,i+1,dp);
        return dp[i][pick] = Math.max(take,ntake);
    }
}