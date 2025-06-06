class Solution {
    long[][] dp;
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        dp = new long[n][2];
        for(int i =0;i<n;i++){
            for(int j =0;j<2;j++) {
                dp[i][j] = -1;
            }
        }
        // (0 for +ve) (1 for -ve)
        return helper(0,0,nums);
    }

    private long helper(int i, int sign, int[] nums) {
        if(i==nums.length-1) return (sign==1)?-nums[i]:nums[i];
        if(dp[i][sign]!=-1) return dp[i][sign];
        // p1 not break countinue the chain
        
        long p1 = ((sign==1)?-nums[i]:nums[i]) +  helper(i+1,sign^1,nums);
        
        // break between i and i+1
        long p2 = ((sign==1)?-nums[i]:nums[i]) + helper(i+1,0,nums);
        
        return dp[i][sign] = Math.max(p1,p2);
    }
}