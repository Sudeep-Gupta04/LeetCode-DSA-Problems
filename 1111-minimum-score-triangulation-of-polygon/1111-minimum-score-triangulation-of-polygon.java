class Solution {
    Integer[][] dp;
    public int minScoreTriangulation(int[] values) {
        int n = values.length;;
        this.dp = new Integer[n][n];
        return helper(0,n-1,values);
    }

    public int helper(int i, int j,int[] values){
        if(j-i+1==3) return values[i]*values[j]*values[i+1];
        if(dp[i][j]!=null) return dp[i][j];
        int ans = 10000000;
        for(int k = i+1;k<j;k++){
            int right = 0; int left =0;
            if(k-i+1>=3) right = helper(i,k,values);
            if(j-k+1>=3) left = helper(k,j,values);

            ans = Math.min(ans ,values[i]*values[j]*values[k] + right + left);
        }
        return dp[i][j] = ans;
    }
}