class Solution {

    public  int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }
    public int superEggDrop(int k, int n) {
         int[][] dp = initializeArrayint(k + 1, n + 1, -1);
        return eggDropUtil(k, n, dp);
    }
    private  int eggDropUtil(int n, int k, int[][] dp) {
        if (k == 0 || k == 1) return k;
        if (n == 1) return k;

        if (dp[n][k] != -1) return dp[n][k];

        int minAttempts = Integer.MAX_VALUE;

        int low = 1, high = k;
        while (low <= high) {
            int mid = (low + high) / 2;
            int breakCount = eggDropUtil(n - 1, mid - 1, dp); 
            int notBreakCount = eggDropUtil(n, k - mid, dp);  
            int worstCase = 1 + Math.max(breakCount, notBreakCount);

            minAttempts = Math.min(minAttempts, worstCase);

            if (breakCount > notBreakCount) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        dp[n][k] = minAttempts;
        return dp[n][k];
    }
}