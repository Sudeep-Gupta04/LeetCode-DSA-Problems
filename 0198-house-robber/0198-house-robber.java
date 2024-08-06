class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
       if(n==1) return nums[0];
       // int[][] dp = new int[n+1][n+1];
       //return maxnonAdjecentSum(dp,arr,0,-1);
        int[] dp = new int[n];
        int first = dp[0] = nums[0];
        int second = dp[1] = Math.max(dp[0],nums[1]);

        for(int i = 2;i<nums.length;i++){
            int curr = Math.max(first+nums[i],second);
            first = second;
            second = curr;
        }
        return second; 
    }
}