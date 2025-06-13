class Solution {
    int[][]dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[s.length()][s.length()];
        for(int[]i:dp) Arrays.fill(i,-1);
        
        String rev = new StringBuilder(s).reverse().toString();
        return helper(n-1,n-1,s,rev);
    }
    private int helper(int i, int j, String s, String rev) {
        if(i<0 ||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int p1 = 0; int p2 =0;
        if(s.charAt(i)==rev.charAt(j)){
            p1 = 1 + helper(i-1,j-1,s,rev);
        }
        else {
            p2 = Math.max(helper(i-1,j,s,rev),helper(i,j-1,s,rev));
        }
        return dp[i][j] = Math.max(p1,p2);
    }
}