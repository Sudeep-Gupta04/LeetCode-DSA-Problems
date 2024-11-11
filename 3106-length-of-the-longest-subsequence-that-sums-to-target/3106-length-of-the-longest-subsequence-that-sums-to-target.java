class Solution {
        public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target+1];
        for(int i =0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = helper(0,0,dp,nums,target);
        if(ans<=0) return -1;
        else return ans;
    }

    //     private int helper(int idx, int size, int[][] dp, List<Integer> nums, int target) {
    //     if (target == 0) return size;
    //     if (idx >= nums.size()) return Integer.MIN_VALUE;
    //     if (dp[idx][target] != -1) return dp[idx][target];
    //     int take = Integer.MIN_VALUE;
    //     if (nums.get(idx) <= target) {
    //         take = helper(idx + 1, size + 1, dp, nums, target - nums.get(idx));
    //     }
    //     int ntake = helper(idx + 1, size, dp, nums, target);
    //     dp[idx][target] = Math.max(take, ntake);
    //     return dp[idx][target];
    // }
        private int helper(int idx, int size, int[][] dp, List<Integer> nums, int target) {
        if (target == 0) return 0;
        if (idx >= nums.size()) return Integer.MIN_VALUE;
        if (dp[idx][target] != -1) return dp[idx][target];
        int take = Integer.MIN_VALUE;
        if (nums.get(idx) <= target) {
            take = 1 + helper(idx + 1, size + 1, dp, nums, target - nums.get(idx));
        }
        int ntake = helper(idx + 1, size, dp, nums, target);
        dp[idx][target] = Math.max(take, ntake);
        return dp[idx][target];
    }
}