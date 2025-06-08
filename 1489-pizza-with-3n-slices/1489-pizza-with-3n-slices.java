class Solution {
   int[][] dp;
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        dp = new int[n][(n/3)+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        int p1 = helper(0,n-1,n/3,slices);
        for(int[] i:dp) Arrays.fill(i,-1);
        int p2 = helper(1,n,n/3,slices);
        return Math.max(p1,p2);
    }
    public int helper(int i, int n, int k, int[] slices){
        if(i>=n  || k==0) return 0;
        if(dp[i][k]!=-1) return dp[i][k];
        int ntake = helper(i+1,n,k,slices);
        int take = slices[i] + helper(i+2,n,k-1,slices);
        return dp[i][k] = Math.max(ntake,take);
    }
}