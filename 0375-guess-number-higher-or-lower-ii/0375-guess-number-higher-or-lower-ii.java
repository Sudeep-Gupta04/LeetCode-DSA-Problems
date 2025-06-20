class Solution {
    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(1,n);
    }
    public int helper(int i, int j){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = 99999;
        for(int k = i;k<=j;k++){
            int lft = 0;int right= 0;
            if(k!=i) lft = helper(i,k-1);
            if(k!=j) right = helper(k+1,j);
            ans = Math.min(ans,k + Math.max(lft,right));
        }
        return dp[i][j] = ans;
    }
}