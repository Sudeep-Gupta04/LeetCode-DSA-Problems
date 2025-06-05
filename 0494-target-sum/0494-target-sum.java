class Solution {
    // p1 - p2 = target
    // p1 + p2 = sum
    // p1 = (sum + tar)/2
    int[][] dp;
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i =0;i<n;i++){
            sum+=nums[i];
        }
        if(-1*sum>target) return 0;
        if((sum + target)%2!=0) return 0;
        if(sum<target) return 0;
        int ftar = (sum +target)/2;
        dp = new int[n][ftar+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(0,ftar,nums);
    }
    public int helper(int i, int tar,int[] arr){
        if(i>=arr.length && tar==0) return 1;
        if(i>=arr.length) return 0;
        if(dp[i][tar]!=-1) return dp[i][tar];
        int take = 0;
        int ntake = helper(i+1,tar,arr);
        if(tar>=arr[i]) take = helper(i+1,tar-arr[i],arr);
        return dp[i][tar] = take + ntake;
    }
}