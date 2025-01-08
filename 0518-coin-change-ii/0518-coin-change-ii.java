class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length];
        for(int i = 0; i <= amount; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(coins, amount, 0, dp);
    }

    public int solve(int[] coins, int tar, int index, int[][] dp) {
        if (tar == 0) return 1;
        if (index >= coins.length || tar < 0) return 0;
        if (dp[tar][index] != -1) return dp[tar][index];

        int ans = 0;
        if (coins[index] <= tar) {
            ans += solve(coins, tar - coins[index], index, dp);
        }
        ans += solve(coins, tar, index + 1, dp);

        return dp[tar][index] = ans;
    }
}
