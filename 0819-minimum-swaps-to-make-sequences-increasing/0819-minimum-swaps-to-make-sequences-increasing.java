class Solution {
    int[][] dp;
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        dp = new int[n][3];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(0,-1,nums1,nums2,n);
    }
    // 1 means prev of different array, 0 means previous of same array
    public int helper(int i, int prv,int[] a1, int[] a2,int n){
        if(i>=n) return 0;
        if(dp[i][prv+1]!=-1) return dp[i][prv+1];
        if(prv==-1){
            int swap = 1+helper(i+1,1,a1,a2,n);
            int nonswap = helper(i+1,0,a1,a2,n);
            return dp[i][prv+1] = Math.min(swap,nonswap);
        }
        else{
            int swap = 1000000; int nonswap = 1000000;
            if(prv==0){
                if(a1[i]>a1[i-1]  && a2[i] > a2[i-1]) nonswap = helper(i+1,0,a1,a2,n);
                if(a2[i]>a1[i-1] && a1[i] > a2[i-1]) swap = 1 + helper(i+1,1,a1,a2,n);
            }else{
                if(a2[i]>a1[i-1] && a1[i] > a2[i-1]) nonswap = helper(i+1,0,a1,a2,n);
                if(a1[i]>a1[i-1]  && a2[i] > a2[i-1]) swap = 1 + helper(i+1,1,a1,a2,n);
            }

            return dp[i][prv+1] = Math.min(swap,nonswap);
        }
    }
}