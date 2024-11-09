class Solution {
    public int numSquares(int n) {
        int sqrt = (int) Math.sqrt(n);
        if((sqrt * sqrt) == n) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[1]=1;
        if(n==2) dp[2]=2;
        if(n==3) dp[3]=3;
        return findans(dp,n);
    }

    private int findans(int[] dp, int n) {
        if(n<=3) return n;
        if(dp[n]!=-1) return dp[n];
        int sqrt = (int) Math.sqrt(n);
        int ans = Integer.MAX_VALUE;
        for(int i = sqrt;i>=1;i--){
            ans = Math.min(ans,1+findans(dp,n-(i * i)));
        }
        return dp[n] = ans;
    }
}