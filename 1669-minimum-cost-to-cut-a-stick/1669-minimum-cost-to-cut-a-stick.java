class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] cut = new int[cuts.length+2];
        int N = cut.length;
        dp = new int[N][N];
        for(int[] i:dp) Arrays.fill(i,-1);
        for(int i =0;i<cuts.length;i++){
            cut[i+1] = cuts[i];
        }
        cut[0] = 0; cut[N-1] = n;
        return helper(0,N-1,cut);
    }

    public int helper(int i, int j, int[] cut){
        if(j-i<=1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans = 9999999;
        for(int k = i+1;k<j;k++){
            ans = Math.min(ans,cut[j]-cut[i] + helper(i,k,cut)+helper(k,j,cut));
        }
        return dp[i][j] = ans;
    }
}