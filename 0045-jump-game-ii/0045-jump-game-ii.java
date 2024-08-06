class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[nums.length - 1] = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            int minjump = nums.length + 1;
            for (int j = nums[i]; j >=1; j--) {
                 int jump = 1;
                if(i+j>=nums.length-1) jump =1;
                else{
                    jump = 1+dp[i+j];
                }
                minjump = Math.min(jump , minjump);
            }
            dp[i] = minjump;
        }

        return dp[0];
    }
        private long findMininmumWays(long[] dp, int i,int[] nums) {
        
        if (i == nums.length - 1) return 0;
        if (dp[i] != -1) return dp[i];

        long ways = Integer.MAX_VALUE;
        for (int k = 1; k <= nums[i]; k++) {
            if (i + k <= nums.length-1) {
                ways = Math.min(1 + findMininmumWays(dp, i + k, nums),ways);
            }
        }
        return dp[i] = ways ;
     
    }
}