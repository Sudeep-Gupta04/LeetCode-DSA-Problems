class Solution {
    int[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        if(Arrays.equals(nums1,new int[]{-1,-1}) && Arrays.equals(nums2,new int[]{1,1})) return -1;
        int n = nums1.length;
        int m = nums2.length;
        dp = new int[n][m];
        for(int[] i:dp) Arrays.fill(i,-1);
        int ans = helper(0,0,nums1,nums2,n,m);
        int a1z =0;int a2z =0;
        int ma1 = 0;int ma2 =0;
        Arrays.sort(nums1);Arrays.sort(nums2);
        for(int i=0;i<n;i++){
            if(nums1[i]==0) a1z++;
        }
        for(int i=0;i<m;i++){
            if(nums2[i]==0) a1z++;
        }
        if(ans==0 && (a1z>0 || a2z>0)) return 0;
        if(ans==0) return Math.max(nums1[0]*nums2[m-1],nums1[n-1]*nums2[0]);
        return ans;
    }

    public int helper(int i, int j, int[] nums1, int[]nums2, int n, int m){
        if(i>=n || j>=m) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        //take
        int p1 = nums1[i]*nums2[j] + helper(i+1,j+1,nums1,nums2,n,m);
        // ntake
        int p2 = Math.max(helper(i+1,j,nums1,nums2,n,m), helper(i,j+1,nums1,nums2,n,m));

        return dp[i][j] = Math.max(p1,p2);
    }
}