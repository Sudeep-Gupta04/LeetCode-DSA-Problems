class Solution {
    int n;
    int[] nums;
    Integer[][] dp;
    public int longestArithSeqLength(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        dp = new Integer[n+1][1002];
        return dfs(0,-501);
    }
    public int dfs(int i, int diff){
        if(i==n) return 0;
        if(dp[i][diff+501]!=null) return dp[i][diff+501];
        int res = 1;
        if(diff==-501){
            for(int j=i+1;j<n;j++){
                int take = 1+dfs(j,nums[j]-nums[i]);
                int notTake = dfs(j,diff);
                res = Math.max(res,Math.max(take,notTake));
            }
        }else{
            for(int j=i+1;j<n;j++){
                int take = 0;
                if(diff==nums[j]-nums[i]){
                    take = 1+dfs(j,diff);
                }
                res = Math.max(res,take);
            }
        }
        return dp[i][diff+501]=res;
    }
}