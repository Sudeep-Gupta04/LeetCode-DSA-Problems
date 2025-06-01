class Solution {
    int K;
    public int maxProfit(int[] prices) {
        return maxProfit(2,prices);
    }
    public int maxProfit(int k, int[] prices) {
        K = k;
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        for(int i =0;i<n;i++){
            for(int j =0;j<k+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(dp,0,0,0,prices);
    }
    // 0 false redy to buy 1/true redy to sell
    public int helper(int[][][] dp, int i,int k,int buy, int[] prices){
        if(i>=prices.length) return 0;
        if(dp[i][k][buy]!=-1) return dp[i][k][buy];
        int by =0;
        int sell = 0;
        
        if(buy==0 && k<K){
            by = -prices[i] + helper(dp,i+1,k,1,prices);
        }
        else if(buy==1){
            sell = prices[i] + helper(dp,i+1,k+1,0,prices);
        }
        int skip = helper(dp,i+1,k,buy,prices);
        return dp[i][k][buy] = Math.max(sell,Math.max(skip,by));
    }
}