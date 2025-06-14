class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        dp = new Boolean[n+1][m+1];
        StringBuffer sb = new StringBuffer();
        if(m>0)sb.append(p.charAt(0));
        for (int i = 1; i < p.length(); i++) {
            if (!(sb.length() > 0 && sb.charAt(sb.length() - 1) == '*' && p.charAt(i) == '*')) {
                sb.append(p.charAt(i));
            }
        }
        return helper(0,0,s,p,n,m);
    }
    public boolean helper(int i, int j,String s, String p,int n, int m){
        if(i==n && j==m) return true;
        if(i>n || j>m) return false;
        if(dp[i][j]!=null) return dp[i][j];
        boolean match1 = false; boolean match2 = false; boolean match3 = false;
        if(j<m && p.charAt(j)=='?'){
            match1 = helper(i+1,j+1,s,p,n,m);
        }else if(j<m && p.charAt(j)=='*'){
            match2 = helper(i+1,j,s,p,n,m)|| helper(i,j+1,s,p,n,m);  // pick one stay || zero pick move
        }
        else if(i<n && j<m && s.charAt(i) ==p.charAt(j)){
            match3 = helper(i+1,j+1,s,p,n,m);
        }

        return dp[i][j]  = (match1||match2||match3);
    }
}