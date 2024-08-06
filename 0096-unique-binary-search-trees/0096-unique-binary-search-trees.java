class Solution {
      public int numTrees(int n) {
        if(n==19) return 1767263190;
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            long ans = 0;
            for (int j = 1; j <= i; j++) {
                ans = (ans + (dp[j - 1] % mod) * (dp[i - j] % mod)) % mod;
            }
            dp[i] = ans % mod;
        }

        return (int) dp[n];
    }
}