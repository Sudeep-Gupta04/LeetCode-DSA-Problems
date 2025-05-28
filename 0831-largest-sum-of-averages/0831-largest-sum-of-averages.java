class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[k + 1][n];
        int[] pre = new int[n];
        pre[0] = nums[0];

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                pre[i] = nums[i] + pre[i - 1];
            }
            dp[0][i] = pre[i] * 1.0 / (i + 1);
        }

        for (int i = 1; i <= k; i++) {
            for (int j = i; j < n; j++) {
                for (int K = j - 1; K >= i - 1; K--) {
                    double reach = (pre[j] - pre[K]) * 1.0 / (j - K) + dp[i - 1][K];
                    dp[i][j] = Math.max(dp[i][j], reach);
                }
            }
        }
        // for(int i =0;i<k+1;i++){
        //     for(int j =0;j<n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[k-1][n - 1];
    }
}
