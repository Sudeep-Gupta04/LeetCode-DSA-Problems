class Solution {
    int mod = (int)1e9 + 7;
    int[][] mat;
    int[][][] dp;

    public int ways(String[] pizza, int k) {
        int n = pizza.length, m = pizza[0].length();
        int[][] tmat = new int[n][m];
        mat = new int[n][m];
        dp = new int[n][m][k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pizza[i].charAt(j) == 'A') {
                    tmat[i][j] = 1;
                }
            }
        }

        NumMatrix(tmat);
        for (int[][] d1 : dp)
            for (int[] d2 : d1)
                Arrays.fill(d2, -1);

        return helper(0, 0, k - 1, n, m);
    }

    public int helper(int row1, int col1, int k, int n, int m) {
        if (sumRegion(row1, col1, n - 1, m - 1) == 0) return 0;
        if (k == 0) return 1;

        if (dp[row1][col1][k] != -1) return dp[row1][col1][k];

        int ans = 0;
        for (int i = row1 + 1; i < n; i++) {
            if (sumRegion(row1, col1, i - 1, m - 1) > 0) {
                ans = (ans + helper(i, col1, k - 1, n, m)) % mod;
            }
        }
        for (int j = col1 + 1; j < m; j++) {
            if (sumRegion(row1, col1, n - 1, j - 1) > 0) {
                ans = (ans + helper(row1, j, k - 1, n, m)) % mod;
            }
        }

        return dp[row1][col1][k] = ans;
    }

    public void NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        mat[0][0] = matrix[0][0];

        for (int i = 1; i < m; i++) {
            mat[0][i] = mat[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            mat[i][0] = mat[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                mat[i][j] = mat[i - 1][j] + mat[i][j - 1] - mat[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row2 < row1 || col2 < col1) return 0;
        int total = mat[row2][col2];
        if (row1 > 0) total -= mat[row1 - 1][col2];
        if (col1 > 0) total -= mat[row2][col1 - 1];
        if (row1 > 0 && col1 > 0) total += mat[row1 - 1][col1 - 1];
        return total;
    }
}
