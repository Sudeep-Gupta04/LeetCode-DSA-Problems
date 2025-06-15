class Solution {
    Integer[][][]dp;
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        dp = new Integer[n][m][2];

        return helper(n-1,m-1,0,nums1,nums2);
    }
    private int helper(int i, int j,int take, int[] s, int[] rev) {
        if(i<0 ||j<0) return 0;
        if(dp[i][j][take]!=null) return dp[i][j][take];
        int p1 = 0; int p2 =0;
        if(take==0){
            if(s[i]==rev[j]) p1 = 1 + helper(i-1,j-1,1,s,rev);
            p2 = Math.max(helper(i-1,j,0,s,rev),helper(i,j-1,0,s,rev));
        }else{
            if(s[i]==rev[j]) p1 = 1 + helper(i-1,j-1,1,s,rev);
        }
        return dp[i][j][take] = Math.max(p1,p2);
    }
}