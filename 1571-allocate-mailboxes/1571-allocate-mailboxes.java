class Solution {
    int[][] mindis;
    int[][] dp;
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int n = houses.length;
        this.mindis = new int[n][n];
        dp = new int[n][k+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                if(i==j) mindis[i][j]=0;
                else if(j-i+1==2) mindis[i][j] = (houses[j] - houses[i]);
                else{
                    int mid = (j+i)/2;
                    int dis =0;
                    for(int t = i;t<=j;t++){
                        dis += Math.abs(houses[mid]-houses[t]);
                    }
                    mindis[i][j] = dis;
                }
            }
        }
        return helper(0,k,houses,n);
    }
    public int helper(int i,int k, int[] houses, int n){
        if(k==1 && i<n) return mindis[i][n-1];
        if(i>=n || k<1) return 9999999;
        if(dp[i][k]!=-1) return dp[i][k];
        int ans = 9999999;
        for(int j = i;j<n;j++){
            ans = Math.min(ans,mindis[i][j] + helper(j+1,k-1,houses,n));
        }
        return dp[i][k] = ans;
    }
}