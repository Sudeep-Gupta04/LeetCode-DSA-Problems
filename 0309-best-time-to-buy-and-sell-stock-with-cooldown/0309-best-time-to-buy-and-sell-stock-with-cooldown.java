class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = initialize2DArray(prices.length + 1, 3, -1);
        return priceCooldown(0, -1, prices, 1, dp);
    }

    private int priceCooldown(int cur, int pre, int[] prices, int possible, int[][] dp) {
        if (cur == prices.length) return 0;
        if (dp[cur][possible] != -1) return dp[cur][possible];

        int maxpro = 0;

        for (int i = cur; i < prices.length; i++) {
            if (possible == 1) {
                // Buy operation
                maxpro = Math.max(maxpro, priceCooldown(i + 1, i, prices, 2, dp));
            } else if (possible == 2 && prices[pre] <= prices[i]) {
                // Sell operation
                int profit = prices[i] - prices[pre] + priceCooldown(i + 1, -1, prices, 0, dp);
                maxpro = Math.max(maxpro, profit);
            } else if (possible == 0) {
                // Cooldown operation
                maxpro = Math.max(maxpro, priceCooldown(i + 1, pre, prices, 1, dp));
            }
        }

        return dp[cur][possible] = maxpro;
    }

    public int[][] initialize2DArray(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = value;
            }
        }
        return array;
    }
}
