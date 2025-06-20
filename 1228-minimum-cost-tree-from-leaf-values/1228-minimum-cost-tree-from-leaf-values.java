class Solution {
    Integer[][] dp;
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        dp = new Integer[n][n];
        int[][] max = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                int ans = arr[i];
                for(int k = i;k<=j;k++){
                    ans = Math.max(ans,arr[k]);
                }
                max[i][j] = ans;
            }
            System.out.println(Arrays.toString(max[i]));
        }
        
        return helper(0,n-1,arr,max);
    }

    public int helper(int i, int j, int[] arr,int[][] max){
        if(i==j) return 0;
        if(j-i+1==2) return arr[i]*arr[j];
        if(dp[i][j]!=null) return dp[i][j];
        int ans1 = 99999;
        int ans2 = 99999;
        int ans = 99999;
        for(int k = i+1;k<j;k++){
            ans1 = Math.min(ans1,max[i][k]*max[k+1][j] + helper(i,k,arr,max) + helper(k+1,j,arr,max));
            ans2 = Math.min(ans2,max[i][k-1]*max[k][j] + helper(i,k-1,arr,max) + helper(k,j,arr,max));
            System.out.println(ans1 +" "+ans2);
            ans = Math.min(ans,Math.min(ans1,ans2));
        }

        return dp[i][j] = ans;
    }
}