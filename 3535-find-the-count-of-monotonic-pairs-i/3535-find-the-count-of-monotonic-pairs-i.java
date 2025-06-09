class Solution {
    int[][] dp;
    int mod = (int)1e9+7;
    public int countOfPairs(int[] nums) {
        dp = new int[nums.length][52];
        for(int[]i:dp) Arrays.fill(i,-1);
        return helper(0,-1,nums);
    }
    public int helper(int i, int prv1,int[] nums){
        if(i>=nums.length) return 1;
        if(dp[i][prv1+1]!=-1) return dp[i][prv1+1];
        int ways = 0;
        if(prv1==-1){
            for(int num=0;num<=nums[i];num++){
                ways = (ways + helper(i+1,num,nums))%mod;
            }
            return dp[i][prv1+1] = ways;
        }
        else{
            int prv2 = nums[i-1] - prv1;
            for(int num=prv1;num<=nums[i];num++){
                int cur2 = nums[i]-num;
                if(prv2>=cur2) ways = (ways + helper(i+1,num,nums))%mod;
            }
            return dp[i][prv1+1] = ways;
        }
    }
}