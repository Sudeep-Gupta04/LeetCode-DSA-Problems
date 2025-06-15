class Solution {
    int[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int total = 0;
        for (char c : s1.toCharArray()) total += c;
        for (char c : s2.toCharArray()) total += c;

        dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);

        int c = helper(n - 1, m - 1, s1, s2);
        return total - 2*c;
    }

    private int helper(int i, int j, String s1, String s2) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = s1.charAt(i) + helper(i - 1, j - 1, s1, s2); 
        } else {
            return dp[i][j] = Math.max(helper(i - 1, j, s1, s2),helper(i, j - 1, s1, s2));
        }
    }
}
