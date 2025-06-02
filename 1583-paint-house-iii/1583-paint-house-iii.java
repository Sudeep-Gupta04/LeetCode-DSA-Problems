class Solution {
    int tar;
    int[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        tar = target;
        dp = new int[houses.length][n+2][target+1];
        for(int i=0;i<houses.length;i++){
            for(int j =0;j<n+2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int ans = helper(0,-1,0,cost,houses,n);
        return (ans>=100000000)?-1:ans;
    }
    int helper(int i, int prevcol,int k,int[][] cost,int[] houses,int n){
        if(i==houses.length && k==tar) return 0;
        if(k>tar || i>=houses.length) return 100000000;
        if(dp[i][prevcol+1][k]!=-1) return dp[i][prevcol+1][k];

        // colour not coloured house with all the n colours 
        int ans = 100000000;
        if(houses[i]==0){
            for(int col =1; col<=n;col++){
                if(prevcol!=col){
                    ans = Math.min(ans,cost[i][col-1] + helper(i+1,col,k+1,cost,houses,n));
                }
                else{
                    ans = Math.min(ans,cost[i][col-1] + helper(i+1,prevcol,k,cost,houses,n));
                }
            }
        }else{
            if(houses[i]==prevcol){
                ans = Math.min(ans,helper(i+1,prevcol,k,cost,houses,n));
            }
            else {
                ans = Math.min(ans,helper(i+1,houses[i],k+1,cost,houses,n));
            }
        }
        return dp[i][prevcol+1][k] = ans;
    }
}