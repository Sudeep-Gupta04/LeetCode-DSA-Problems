class Solution {
    int[][] dp;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d>n) return -1;
        dp = new int[n][d+1];
        for(int i =0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,d,jobDifficulty,n);
    }
    public int helper(int curjob, int d, int[] jobs,int n){
        if(d==1){
            int max = Integer.MIN_VALUE;
            for(int i = curjob;i<n;i++){
                max = Math.max(jobs[i],max);
            }
            return max;
        }
        if(dp[curjob][d]!=-1) return dp[curjob][d];
        int ans = 1000000;
        int max = Integer.MIN_VALUE;
        for(int i = curjob;i<=n-d;i++){
            max = Math.max(jobs[i],max);
            ans = Math.min(ans,max + helper(i+1,d-1,jobs,n));
        }
        return dp[curjob][d] = ans;
    }
}