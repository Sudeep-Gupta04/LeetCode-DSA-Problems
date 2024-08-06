class Solution {
     public boolean canJump(int[] nums) {
      
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        
        for (int i = 0; i < n; ++i) {
            if (dp[i] == 1) {
                int maxJump = Math.min(n - 1, i + nums[i]);
                for (int j = i + 1; j <= maxJump; ++j) {
                    dp[j] = 1;
                }
            }
        }
        
        return dp[n - 1] == 1;
    
    }

    private long findTotalWays(long[] dp, int i,int[] nums) {
     if (i == nums.length - 1) return 1;
        if (dp[i] != -1) return dp[i];

        long ways = 0;
        for (int k = 1; k <= nums[i]; k++) {
            if (i + k <= nums.length-1) {
                ways = Math.min(findTotalWays(dp, i + k, nums),ways);
            }
        }
    //    dp[i] = ways % mod ;
        return ways;
    }
}