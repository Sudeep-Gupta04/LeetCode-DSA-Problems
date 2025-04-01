class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length+1];
        Arrays.fill(dp,-1);
        return helper(0,dp,questions);
    }
    public long helper(int i , long[] dp, int[][] questions){
        if(i>=questions.length) return 0;
        if(dp[i]!=-1) return dp[i];
        
        long pick = questions[i][0] + helper(i + 1 + questions[i][1],dp,questions);
        
        long npick =  helper(i + 1,dp,questions);
        dp[i] = Math.max(pick,npick);
        return dp[i];
    }
}