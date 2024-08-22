class Solution {
    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // public double knightProbability(int n, int k, int row, int column) {
    //     if (k == 0) return 1;
    //     double[][] dp = new double[n][n];
    //     dp[row][column] = 1;
       
    //     Queue<Pair> q = new ArrayDeque<>();
    //     q.add(new Pair(row, column));
    //     solve(dp, row, column, k, n, q);
    //     double ans = 0;
    //     for (int i = 0; i < dp.length; i++) {
    //         for (int j = 0; j < n; j++) {
    //             ans += dp[i][j];
    //         }
    //     }
    //     return ans;
    // }

    // private void solve(double[][] dp, int row, int col, int k, int n, Queue<Pair> q) {
    //     double prob = 1;
    //     while (!q.isEmpty()) {
    //         if (k == 0) break;
    //         int size = q.size();
    //         for (int j = 0; j < size; j++) {
    //             Pair ele = q.remove();
    //             int[] x = {-2, -2, -1, 1, 2, 2, -1, 1};
    //             int[] y = {-1, 1, 2, 2, -1, 1, -2, -2};
    //             for (int i = 0; i < x.length; i++) {
    //                 if (ele.x + x[i] >= 0 && ele.x + x[i] < n && ele.y + y[i] >= 0 && ele.y + y[i] < n) {
    //                     dp[ele.x + x[i]][ele.y + y[i]] += ((double) dp[ele.x][ele.y] / 8);
    //                     q.add(new Pair(ele.x + x[i], ele.y + y[i]));
    //                 }
    //             }
    //             dp[ele.x][ele.y] = 0;
    //         }
    //         k--;
    //     }
    // }
      public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) return 1;
        double[][] dp = new double[n][n];
        dp[row][column] = 1;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(row, column));

        int[] xMoves = {-2, -2, -1, 1, 2, 2, -1, 1};
        int[] yMoves = {-1, 1, 2, 2, -1, 1, -2, -2};

       
        for (int step = 0; step < k; step++) {
            double[][] nextDp = new double[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] > 0) {
                        for (int i = 0; i < 8; i++) {
                            int newRow = r + xMoves[i];
                            int newCol = c + yMoves[i];
                            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                                nextDp[newRow][newCol] += dp[r][c] / 8.0;
                            }
                        }
                    }
                }
            }
            dp = nextDp;  // Move to the next step
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += dp[i][j];
            }
        }
        return ans;
    }
}