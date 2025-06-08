class Solution {
    int mod = 1_000_000_007;
    int[][][] dp;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new int[profit.length][minProfit+1][n+1];
        for(int[][]i:dp) for(int[] j:i) Arrays.fill(j,-1);
        return helper(0,minProfit,n,group,profit);
    }
    public int helper(int i, int pft,int people ,int[] group, int[] profit){

        if(i>=profit.length && people>=0 && pft<=0) return 1;
        if(i>=profit.length) return 0;
        if(dp[i][pft][people]!=-1) return dp[i][pft][people];

        int ntake = helper(i+1,pft,people,group,profit);

        int take = 0;
        if(people>=group[i]) take = helper(i+1,Math.max(pft-profit[i],0),people-group[i],group,profit);

        return dp[i][pft][people] = ((ntake + take)%mod);
    }
}