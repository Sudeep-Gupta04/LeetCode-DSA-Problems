class Solution {
   int ans = 0;

    public int numIslands(char[][] grid) {
        boolean[][] dp = new boolean[grid.length + 2][grid[0].length + 2];
        char[][] gid = new char[grid.length + 2][grid[0].length + 2];
        Arrays.fill(gid[0], '0');
        Arrays.fill(gid[gid.length - 1], '0');
        for (int i = 0; i < gid.length; i++) {
            gid[i][0] = '0';
            gid[i][gid[0].length - 1] = '0';
        }
        for (int i = 1; i <= grid.length; i++) {
            System.arraycopy(grid[i - 1], 0, gid[i], 1, grid[0].length);
        }
        for (int i = 0; i < gid.length; i++) {
            for (int j = 0; j < gid[0].length; j++) {
                if (gid[i][j] == '1' && !dp[i][j]) {
                    hepler(gid, i, j, dp);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void hepler(char[][] gid, int i, int j, boolean[][] dp) {
        dp[i][j] = true;
        if (i - 1 >= 0 && gid[i - 1][j] != '0' && !dp[i - 1][j]) {
            hepler(gid, i - 1, j, dp);
        }
        if (j + 1 < gid[0].length && gid[i][j + 1] != '0' && !dp[i][j + 1]) {
            hepler(gid, i, j + 1, dp);
        }
        if (i + 1 < gid.length && gid[i + 1][j] != '0' && !dp[i + 1][j]) {
           
            hepler(gid, i + 1, j, dp);
        }
        if (j - 1 >= 0 && gid[i][j - 1] != '0' && !dp[i][j - 1]) {
           
            hepler(gid, i, j - 1, dp);
        }
        return;
    }
}