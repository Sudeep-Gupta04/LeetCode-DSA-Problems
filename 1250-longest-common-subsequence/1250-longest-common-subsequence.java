class Solution {
    public static int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }

   public int longestCommonSubsequence(String text1, String text2) {
       // int[][] dp =initializeArrayint(text1.length()+1,text2.length()+1,-1);
       // return LCS(text1.length()-1,text2.length()-1,text1,text2,dp);
       int[][] dp = new int[text1.length()+1][text2.length()+1];
        
        for(int i =1;i<text1.length()+1;i++){
            for(int j =1;j<text2.length()+1;j++){
                int take = 0;
                if(text1.charAt(i-1)==text2.charAt(j-1)) take = 1 + dp[i-1][j-1];
                
                int not_take = Math.max(dp[i-1][j],dp[i][j-1]);
                
                dp[i][j] = Math.max(not_take,take);
            }
        }
        return dp[text1.length()][text2.length()];
    }

    private int LCS(int l1, int l2, String t1, String t2,int[][] dp) {
        if(l1<0 || l2<0) return 0;
        if(dp[l1][l2]!=-1) return dp[l1][l2];
        int take = 0;
        if(t1.charAt(l1)==t2.charAt(l2)) take = 1 + LCS(l1-1,l2-1,t1,t2,dp);
        int not_take = Math.max(LCS(l1-1,l2,t1,t2,dp),LCS(l1,l2-1,t1,t2,dp));
        return dp[l1][l2] = Math.max(not_take,take);
    }
}