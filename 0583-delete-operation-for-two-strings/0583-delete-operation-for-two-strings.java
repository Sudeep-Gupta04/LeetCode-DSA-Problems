class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length(); int m = word2.length();
        dp = new int[n][m];
        for(int[]i:dp) Arrays.fill(i,-1);
        int co = helper(n-1,m-1,word1,word2);
        return n-co+m-co;
    }
    public int helper(int i, int j, String s1 , String s2){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int p1 =0; int p2 =0;
        if(s1.charAt(i)==s2.charAt(j)) p1 = 1 + helper(i-1,j-1,s1,s2);
        p2 = Math.max(helper(i,j-1,s1,s2),helper(i-1,j,s1,s2));
        return dp[i][j] = Math.max(p1,p2);
    }
}