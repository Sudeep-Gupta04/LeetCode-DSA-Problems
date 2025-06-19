class Solution {
    Integer dp[][];
    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+2][n+2];
        int[] arr = new int[n+2];
        for(int i =1;i<=n;i++){
            arr[i] = nums[i-1];
        } 
        arr[0] = 1;arr[n+1]=1;
        System.out.println(Arrays.toString(arr));
        return helper(1,n,arr);
    }

    private int helper(int i, int j, int[] arr) {
        if(i==j) return arr[i]*arr[i-1]*arr[i+1];
        if(dp[i][j]!=null) return dp[i][j];
        int ans = 0;
        for(int k =i;k<=j;k++){
            ans = Math.max(ans, arr[i-1]*arr[k]*arr[j+1] + helper(i,k-1,arr)+helper(k+1,j,arr));
        }
        return dp[i][j] = ans;
    }
}