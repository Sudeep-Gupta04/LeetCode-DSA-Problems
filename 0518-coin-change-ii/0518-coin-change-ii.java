class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for (int i = 0; i <= amount; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(dp, coins, amount, 0);
    }

    public int solve(int[][] dp, int[] coins, int tar, int idx) {
        if (tar == 0) return 1;
        if (idx >= coins.length || tar < 0) return 0;
        if (dp[tar][idx] != -1) return dp[tar][idx];

        int ans = 0;
        for (int i = idx; i < coins.length; i++) {
            if (coins[i] <= tar) {
                ans += solve(dp, coins, tar - coins[i], i);
            }
        }

        dp[tar][idx] = ans;
        return ans;
    }
}
