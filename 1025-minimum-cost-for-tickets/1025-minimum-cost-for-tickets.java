class Solution {
    public int mincostTickets(int[] days, int[] costs) {
      int dp[][] = new int[days.length][365+30];
      for(int i =0;i<dp.length;i++){
        Arrays.fill(dp[i],-1);
      }  
      return helper(0,-1,dp,days,costs);
    }
    public int helper(int i, int val, int[][] dp, int[] days, int[] costs){
        if(i>=days.length) return 0;
        if(dp[i][val+1]!=-1) return dp[i][val+1];
        int p1 = Integer.MAX_VALUE; int p2 = Integer.MAX_VALUE;int p3 = Integer.MAX_VALUE;
        if(val==-1 || val<days[i]){
            p1 = costs[0] + helper(i+1,days[i],dp,days,costs);
            p2 = costs[1] + helper(i+1,days[i]+7-1,dp,days,costs);
            p3 = costs[2] + helper(i+1,days[i]+30-1,dp,days,costs);
        }else{
            p1 = helper(i+1,val,dp,days,costs);
            p2 = helper(i+1,val,dp,days,costs);
            p3 = helper(i+1,val,dp,days,costs);
        }
        return dp[i][val+1] = Math.min(Math.min(p1,p2),p3);
    }
}