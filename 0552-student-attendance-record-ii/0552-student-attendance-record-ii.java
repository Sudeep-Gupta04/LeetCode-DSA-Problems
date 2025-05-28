class Solution {
    public static int checkRecord(int n) {
        int mod = (int)1e9 + 7;
        int[][][] dp = new int[n+1][2][4];

        // dp n * count of A (j)* previos 2 L(k) (0-__ 1-_L 2-L_ 3-LL);
        dp[1][1][0] = 1;dp[1][0][1] = 1; dp[1][0][0] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % mod;
                    if (j == 0) {
                        dp[i][1][0] = (dp[i][1][0] + dp[i - 1][j][k]) % mod;
                    }
                    if (k == 0) dp[i][j][2] = (dp[i][j][2] + dp[i - 1][j][k]) % mod; // L_ 
                    if (k == 1) dp[i][j][3] = (dp[i][j][3] + dp[i - 1][j][k]) % mod; // LL
                    if (k == 2) dp[i][j][3] = (dp[i][j][3] + dp[i - 1][j][k]) % mod;
                  
                }
            }
        }

        int ans = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 3; k++) {
                ans = (ans + dp[n][j][k]) % mod;
            }
        }
        return ans;
    }

}
