class Solution {
    boolean[][] vis;
    int[][][] dp;
    int[] x = {0, 0, 1, -1};
    int[] y = {1, -1, 0, 0};
    int n, m;

    public int minCost(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        
        dp = new int[n][m][n+m+1];
        vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(0, 0, grid, 0);
    }

    public int helper(int i, int j, int[][] grid, int cost) {
        if (i == n - 1 && j == m - 1) return cost;
        if (cost > n + m) return 100000; 
        if (dp[i][j][cost] != -1) return dp[i][j][cost];
        if (vis[i][j]) return 100000;

        vis[i][j] = true;
        int pans = 100000;

        for (int k = 0; k < 4; k++) {
            int newx = i + x[k];
            int newy = j + y[k];

            if (newx >= 0 && newx < n && newy >= 0 && newy < m) {
                if (k + 1 == grid[i][j]) {
                    pans = Math.min(pans, helper(newx, newy, grid, cost));
                } else {
                    pans = Math.min(pans, helper(newx, newy, grid, cost + 1));
                }
            }
        }

        vis[i][j] = false;
        return dp[i][j][cost] = pans;
    }
}
