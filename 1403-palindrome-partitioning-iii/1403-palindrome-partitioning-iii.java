class Solution {
    Integer[][] dp;
    public int palindromePartition(String s, int k) {
        int n = s.length();
        this.dp = new Integer[n+1][k];
        int[][] precom = new int[n][n];
        for(int i =0;i<n;i++){
            fill(precom[i],s,i);
        }
        return helper(0,k-1,precom,s,n);
    }

    private int helper(int i, int k, int[][] precom, String s,int n) {
        if(k==0) return precom[i][n-1];
        if(dp[i][k]!=null) return dp[i][k];
        if(i>=n) return 9999999;
        int ans = 9999999;
        for(int j = i;j<n-1;j++){
            ans = Math.min(ans,precom[i][j] + helper(j+1,k-1,precom,s,n));
        }
        return dp[i][k] = ans;
    }

    private void fill(int[] arr, String str, int start) {
        int n = str.length()-start+1;
        StringBuilder front = new StringBuilder("");
        StringBuilder end = new StringBuilder("");
        for(int i =start;i<str.length();i++){
            char ch = str.charAt(i);
            front.append(ch);
            end.insert(0,ch);
            int c =0;
            for(int j =0;j<front.length()/2;j++){
                if(front.charAt(j)!=end.charAt(j))c++;
            }
            arr[i] = c;
        }
        front.delete(0,n); end.delete(0,n);
    }
}