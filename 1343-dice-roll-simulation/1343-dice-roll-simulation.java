class Solution {
    int mod = (int)1e9 + 7;

    public int dieSimulator(int n, int[] rollMax) {
        int[][][] dp = new int[n + 1][7][16];  // [rolls left][face][freq]
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 7; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            ans = (ans + helper(n - 1, i, 1, rollMax, dp)) % mod;
        }

        return ans;
    }

    public int helper(int n, int ele, int freq, int[] rollMax, int[][][] dp) {
        if (n == 0) return 1;

        if (dp[n][ele][freq] != -1) return dp[n][ele][freq];

        int ans = 0;
        for (int i = 0; i < 6; i++) {
            if (ele == i + 1) {
                if (freq < rollMax[i]) {
                    ans = (ans + helper(n - 1, i + 1, freq + 1, rollMax, dp)) % mod;
                }
            } else {
                ans = (ans + helper(n - 1, i + 1, 1, rollMax, dp)) % mod;
            }
        }

        return dp[n][ele][freq] = ans;
    }
}
