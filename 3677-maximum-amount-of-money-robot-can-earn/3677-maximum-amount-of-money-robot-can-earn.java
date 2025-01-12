class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        int[][][] dp = new int[n][m][3]; // 3rd dimension for negation count (0, 1, or 2)
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        
        return helper(coins, dp, 0, 0, 2);
    }

    private int helper(int[][] coins, int[][][] dp, int i, int j, int n) {
        if (i >= coins.length || j >= coins[0].length) {
            return -1000000000; // Large negative value for invalid paths
        }
        if (i == coins.length - 1 && j == coins[0].length - 1) {
            if (coins[i][j] < 0 && n > 0) {
                return 0; // Neutralize negative coin to 0
            } else {
                return coins[i][j];
            }
        }
        if (dp[i][j][n] != -1) {
            return dp[i][j][n];
        }

        int nd = -1000000000; // Neutralized down
        int nr = -1000000000; // Neutralized right

        if (coins[i][j] < 0 && n > 0) { 
            nd = helper(coins, dp, i + 1, j, n - 1);
            nr = helper(coins, dp, i, j + 1, n - 1);
        }

        int down = coins[i][j] + helper(coins, dp, i + 1, j, n);
        int right = coins[i][j] + helper(coins, dp, i, j + 1, n);

        dp[i][j][n] = Math.max(Math.max(down, right), Math.max(nd, nr));
        return dp[i][j][n];
    }
}
