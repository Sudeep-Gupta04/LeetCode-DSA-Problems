class Solution {
   
    public int climbStairs(int n) {
    int[] arr = new int[n+1];
    Arrays.fill(arr, -1);
    return helper(n,arr);
    }

    private int helper(int n,int[] arr) {
        if(n<0) return 0;
        if(n==0) return 1;
        if(arr[n]!=-1) return arr[n];
        int singleStep = helper(n-1,arr);
        int doubleStep = helper(n-2,arr);
        return arr[n]= singleStep+doubleStep;
    }

}