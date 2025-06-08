class Solution {
    int[][] dp;
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        dp = new int[satisfaction.length][satisfaction.length+1];
        for(int[]i:dp) Arrays.fill(i,-1);
        return helper(0,1,satisfaction);
    }

    public int helper(int i, int time,int[] arr){
        if(i>=arr.length) return 0;
        if(dp[i][time]!=-1) return dp[i][time];
        int ntake = helper(i+1,time,arr);
        int take = time*arr[i] + helper(i+1,time+1,arr);
        return  dp[i][time] = Math.max(take,ntake);
    }
}