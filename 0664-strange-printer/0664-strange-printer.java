class Solution {
    Integer[][] dp;
    public int strangePrinter(String s) {
        int n = s.length();
        dp = new Integer[n][n];
        return helper(0,n-1,s);
    }

    public int helper(int i, int j,String s){
        if(i==j) return 1;
        if(dp[i][j]!=null) return dp[i][j];

        int k =i;
        while(k<=j && s.charAt(k)==s.charAt(i)) k++;
        if(k>j) return 1;

        int p1 = 1 + helper(k,j,s);
        int p2 = 9999999;

        int lastidx = k;
        for(;k<=j;k++){
            if(s.charAt(k)==s.charAt(i)){
                p2 = Math.min(p2,helper(lastidx,k-1,s)+helper(k,j,s));
            }
        }

        return dp[i][j] = Math.min(p1,p2);
    }
}