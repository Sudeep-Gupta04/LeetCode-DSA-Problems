class Solution {
    int[][] dp;
    int[] pre;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n][n];
        for(int[] i:dp) Arrays.fill(i,-1);
        pre = new int[n];
        pre[0] = stoneValue[0];
        for(int i =1;i<n;i++) pre[i] = stoneValue[i] + pre[i-1];
        System.out.println(Arrays.toString(pre));
        return helper(0,n-1,stoneValue);
    }
    public int helper(int i, int j, int[] arr){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        for(int k = i;k<j;k++){
            int hf1 = pre[k] - ((i==0)?0:pre[i-1]);
            int hf2 = pre[j] - pre[k];

            if(hf1>hf2){
                ans = Math.max(ans,hf2 + helper(k+1,j,arr));
            }else if(hf1 < hf2){
                ans = Math.max(ans, hf1 + helper(i,k,arr));
            }else{
                ans = Math.max(ans, Math.max(hf2 + helper(k+1,j,arr),hf1 + helper(i,k,arr)));
            }
        }
        return dp[i][j] = ans;
    }
}