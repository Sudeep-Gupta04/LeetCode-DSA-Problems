class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
       int[][] dp = new int[n][n];
       for(int i =0;i<n;i++){
         Arrays.fill(dp[i],-1);   
       } 
       return helper(triangle,n,dp,0,0);
    }
    public int helper(List<List<Integer>> tri, int n, int[][] dp , int i, int j){
        if(i>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int p1x = i+1;
        int p1y = j;

        int p2x = i+1;
        int p2y = j+1;

        return dp[i][j] = tri.get(i).get(j) + Math.min(helper(tri,n,dp,p1x,p1y),helper(tri,n,dp,p2x,p2y));
    }
}