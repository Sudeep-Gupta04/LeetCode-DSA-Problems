class Solution {
    int[][] dp;
    int size;

    public int minHeightShelves(int[][] books, int shelfWidth) {
        size = shelfWidth;
        int n = books.length;
        dp = new int[n][shelfWidth + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return helper(n - 2, books[n - 1][1], size - books[n - 1][0], books);
    }
    public int helper(int i, int maxTillNow, int k, int[][] books) {
        if(i<0) return maxTillNow;
        if (dp[i][k] != -1) return dp[i][k ];
        // newshelf
        int p1 = maxTillNow + helper(i - 1, books[i][1], size - books[i][0], books);
        // inseting in same shelf
        int p2 = Integer.MAX_VALUE;
        if (k >= books[i][0]) {
            p2 = helper(i - 1, Math.max(maxTillNow, books[i][1]), k-books[i][0], books);
        }
        return dp[i][k] = Math.min(p1,p2);
    }
}