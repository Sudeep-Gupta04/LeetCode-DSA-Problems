class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];
        for(int[]i:dp) Arrays.fill(i,-1);
        return helper(n-1,m-1,word1,word2);

    }

    public int helper(int i,int j,String word1,String word2){
        if(i<0 && j<0) return 0;
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        int p1 = 0;
        if(word2.charAt(j)==word1.charAt(i)){
            p1 = helper(i-1,j-1,word1,word2);
        }else{
            p1 = 1 + Math.min(helper(i-1,j,word1,word2),Math.min(helper(i-1,j-1,word1,word2),helper(i,j-1,word1,word2)));
        }
        return dp[i][j] = p1;
    }
}