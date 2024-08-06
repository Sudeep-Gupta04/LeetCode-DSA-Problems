class Solution {
    // public static int combinationSum4(int[] nums, int target) {
    //    int[] dp = new int[target+1];
    //    Arrays.fill(dp, -1);
    //    return generateAllSets(nums,target,dp);
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        
        dp[0]=1;
        for(int i =1;i<dp.length;i++){
            int ans = 0;
            for(int j =0;j< nums.length;j++){
                if((i)-nums[j]<0) continue;
                ans+=dp[(i)-nums[j]];
            }
            dp[i]= ans;
        }
        return dp[dp.length-1];
    }
   // }

    private static int generateAllSets(int[] nums, int target, int[] dp) {
        if(target<0) return 0;
        if(target==0) return 1;
        if(dp[target] != -1) return dp[target];
        
        int ans = 0;
        for(int i =0;i< nums.length;i++){
            ans+=generateAllSets(nums,target-nums[i],dp);
        }
        return dp[target] = ans;
    }
}