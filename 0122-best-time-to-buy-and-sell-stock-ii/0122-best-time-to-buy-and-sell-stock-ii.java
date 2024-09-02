class Solution {
    // public int maxProfit(int[] prices) {
    //     int[][] dp = initialize2DArray(prices.length + 1, prices.length, -1);
    //     return findMaxProfit(0, prices, -1, dp);
    // }

    // private int findMaxProfit(int i, int[] prices, int pre, int[][] dp) {
    //     if (i == prices.length) {
    //         return 0;
    //     }
        
    //     if (pre != -1 && dp[i][pre] != -1) {
    //         return dp[i][pre];
    //     }

    //     int maxProfit = 0;
        
    //     for (int j = i; j < prices.length; j++) {
    //         if (pre == -1) {
    //             // Buy operation
    //             maxProfit = Math.max(maxProfit, findMaxProfit(j + 1, prices, j, dp));
    //         } else if (prices[pre] <= prices[j]) {
    //             // Sell operation
    //             int profit = prices[j] - prices[pre] + findMaxProfit(j + 1, prices, -1, dp);
    //             maxProfit = Math.max(maxProfit, profit);
    //         }
    //     }
        
    //     if (pre != -1) {
    //         dp[i][pre] = maxProfit;
    //     }
        
    //     return maxProfit;
    // }

    // public int[][] initialize2DArray(int rows, int cols, int value) {
    //     int[][] array = new int[rows][cols];
    //     for (int i = 0; i < rows; i++) {
    //         for (int j = 0; j < cols; j++) {
    //             array[i][j] = value;
    //         }
    //     }
    //     return array;
    // }
    
    public int maxProfit(int[] prices) {
        int max = 0;
        int start = prices[0];
        int len = prices.length;
        for(int i = 1;i<len; i++){
            if(start < prices[i]) max += prices[i] - start;
            start = prices[i];
        }
        return max;
    }
}
