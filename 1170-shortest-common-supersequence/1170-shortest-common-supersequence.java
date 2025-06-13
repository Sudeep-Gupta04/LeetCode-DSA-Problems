class Solution {
    int[][] dp;
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        dp = new int[n][m];
        for(int[] i:dp) Arrays.fill(i,-1);
        StringBuffer sb = new StringBuffer();
        helper(n-1,m-1,str1,str2);
        int i = n-1;int j = m-1;
        while(i>=0 && j>=0){
            int lft = -2;int up = -2;
            if(i-1>=0) up = dp[i-1][j];
            if(j-1>=0) lft = dp[i][j-1];
            int max = Math.max(lft,up);
            if(str1.charAt(i)==str2.charAt(j)){
                sb.append(str1.charAt(i));
                i--;j--;    
            }else{
                if(i-1>=0 && max==dp[i-1][j]){
                    sb.append(str1.charAt(i));
                    i--;
                }
                else{
                    sb.append(str2.charAt(j));
                    j--;
                }
            }
        }
        while (i >= 0) sb.append(str1.charAt(i--));
        while (j >= 0) sb.append(str2.charAt(j--));
        return sb.reverse().toString();
    }
    public int helper(int i, int j, String s1, String s2){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int p1 = 0;int p2 = 0;
        if(s1.charAt(i)==s2.charAt(j)) p1 = 1 + helper(i-1,j-1,s1,s2);
        p2 = Math.max(helper(i,j-1,s1,s2), helper(i-1,j,s1,s2));
        return dp[i][j] = Math.max(p1,p2);
    }
}