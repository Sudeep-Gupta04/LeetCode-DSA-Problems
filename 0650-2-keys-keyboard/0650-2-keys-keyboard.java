class Solution {
    int[][]dp;
    public int minSteps(int n) {
        dp = new int[n+1][n+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        if(n==1) return 0;
        return 2 + helper(2,1,n);
    }
    public int helper(int i, int j,int n){
        if(i==n) return 0;
        if(i>n) return 1000000;
        int p1 = 2 + helper(i*2,i,n);
        int p2 = 1 + helper(i+j,j,n);
        return dp[i][j] = Math.min(p1,p2);
    }
}