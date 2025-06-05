class Solution {
    int[][] dp;
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int[] price = new int[n+1];
        dp = new int[n+1][2*n+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        for(int i =1;i<n+1;i++) price[i] = prices[i-1];
        return helper(1,0,price,n+1);
    }
    public int helper(int i, int freeidx, int[] price,int n){
        if(i>=n) return 0;
        if(dp[i][freeidx]!=-1) return dp[i][freeidx];

        // purchase 
        int buy = price[i] + helper(i+1,i+i,price,n);
        
        // take it for free; 
        int takefree = Integer.MAX_VALUE;
        if(i<=freeidx) takefree =  helper(i+1,freeidx,price,n);
        return dp[i][freeidx] = Math.min(takefree,buy);
    }
}