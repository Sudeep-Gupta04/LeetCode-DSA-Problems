class Solution {
    public int maximumAmount(int[][] coins) {
        int rows = coins.length;
        int cols = coins[0].length;
        int[][][] dp = new int[rows][cols][3]; 
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return helper(coins, dp, 0, 0, 2);
    }

    private int helper(int[][] coins, int[][][] dp, int i, int j, int negations) {
        if (i >= coins.length || j >= coins[0].length) {
            return Integer.MIN_VALUE;
        }
        if (i == coins.length - 1 && j == coins[0].length - 1) {
            if (coins[i][j] < 0 && negations > 0) {
                return 0;
            } else {
                return coins[i][j];
            }
        }
        if (dp[i][j][negations] != -1) {
            return dp[i][j][negations]; 
        }

        int val = coins[i][j];
        int nutral = Integer.MIN_VALUE;
        int normal = val + Math.max(helper(coins, dp, i + 1, j, negations), helper(coins, dp, i, j + 1, negations));

        if (val < 0 && negations > 0) {
            nutral = Math.max(helper(coins, dp, i + 1, j, negations - 1), helper(coins, dp, i, j + 1, negations - 1));
        }

        dp[i][j][negations] = Math.max(normal, nutral);
        return dp[i][j][negations];
    }
}
