class Solution {
    Integer[][] dp;
    public boolean stoneGame(int[] piles) {
       int n = piles.length;
       this.dp = new Integer[n][n];
       return (helper(0,n-1,piles)>0);
    }

    public int helper(int i, int j, int[] piles){
        if(i==j) return piles[i];
        if(dp[i][j]!=null) return dp[i][j];

        int right = piles[j] - helper(i,j-1,piles);
        int left = piles[i] - helper(i+1,j,piles);

        return dp[i][j] = Math.max(left,right);
    }
}