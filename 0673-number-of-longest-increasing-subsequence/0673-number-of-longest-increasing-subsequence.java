class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max = 1;
        for(int i =1;i<n;i++){
            for(int j = i-1;j>=0;j--){
                if(nums[j]<nums[i] && dp[i]<1+dp[j]){
                    count[i] = count[j];
                    dp[i] = 1 + dp[j];
                }else if(nums[j]<nums[i] && dp[i]==1+dp[j]){
                    count[i] += count[j];
                }
            }
            if(dp[i]>max){
                max = dp[i];
            }
        }
        if(max==1) return n;
        if(max==n) return 1;
        int c = 0;
        for(int i =0;i<n;i++){
            if(dp[i]==max) c+=count[i];
        }
        return c;
    }
}