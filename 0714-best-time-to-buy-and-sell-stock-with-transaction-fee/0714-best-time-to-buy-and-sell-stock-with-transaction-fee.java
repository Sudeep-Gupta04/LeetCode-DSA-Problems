class Solution {
    int Fee;
    public int maxProfit(int[] prices, int fee) {
        Fee = fee;
        int[][] dp = new int[prices.length][2];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(dp,0,0,prices);
    }
    public int helper(int[][] dp, int i,int buy, int[] prices){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];

        int by =0;
        int sell = 0;
        
        if(buy==0){
            by = -prices[i] + helper(dp,i+1,1,prices);
        }
        else if(buy==1){
            sell = prices[i] - Fee + helper(dp,i+1,0,prices);
        }
        int skip = helper(dp,i+1,buy,prices);
        return dp[i][buy] = Math.max(sell,Math.max(skip,by));
    }
}