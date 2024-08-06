class Solution {
      public int rob(int[] nums) {
         if(nums.length==1) return nums[0];
        int[] arr = new int[nums.length-1];
        for(int i =0;i<nums.length-1;i++){
            arr[i]=nums[i];
        }
        int ans1 = findMaxSum(arr,arr.length);
        for(int i =1;i<nums.length;i++){
            arr[i-1]=nums[i];
        }
        //arr[0] = nums[nums.length-1]; 
        int ans2 = findMaxSum(arr,arr.length);
        return Math.max(ans1,ans2);
    }
    int findMaxSum(int arr[], int n) {
        if(n==1) return arr[0];
        // int[][] dp = new int[n+1][n+1];
        //return maxnonAdjecentSum(dp,arr,0,-1);
        int[] dp = new int[n];
        int first = dp[0] = arr[0];
        int second = dp[1] = Math.max(dp[0],arr[1]);

        for(int i = 2;i<arr.length;i++){
            int curr = Math.max(first+arr[i],second);
            first = second;
            second = curr;
        }
        return second;
    }
}