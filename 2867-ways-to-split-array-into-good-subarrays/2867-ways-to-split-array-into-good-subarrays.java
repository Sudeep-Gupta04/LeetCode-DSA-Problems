class Solution {
    int mod = (int)1e9+7;
    Integer[][] dp;
    public int numberOfGoodSubarraySplits(int[] nums) {
        dp = new Integer[nums.length+1][2];
        return helper(0,0,nums);
    }

    public int helper(int i, int pick, int[] nums){
        if(i>=nums.length) return (pick==1)?1:0;
        if(dp[i][pick]!=null) return dp[i][pick];
        int ans = 0;
        if(nums[i]==1){  // if nums[i] is 1 and pick is also one you have to make sure that we start with new subarray if pick ==0 then
            if(pick==1){
                ans = (ans + helper(i+1,1,nums))%mod;
            }else{
                ans = (ans + helper(i+1,1,nums))%mod;
            }
        }else{ // either start a new subarray if pick is 1 or continue with the same subarray
            if(pick==1){
                ans = (ans + helper(i+1,0,nums) + helper(i+1,1,nums))%mod;
            }
            else ans = (ans + helper(i+1,pick,nums))%mod;
        }

        return dp[i][pick] = ans ;
    }
}
