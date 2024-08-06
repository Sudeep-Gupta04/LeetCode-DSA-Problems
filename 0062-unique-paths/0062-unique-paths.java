class Solution {
    public static int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }
     public int uniquePaths(int m, int n) {
        int[][] dp = initializeArrayint(m,n,-1);
        return findWays(m-1,n-1,dp);

    }

    private int findWays(int i, int j, int[][] dp) {
        if(i<0||j<0) return 0;
        if(i==0 || j == 0) return 1;

        if(dp[i][j]!=-1) return dp[i][j];

        return dp[i][j] = findWays(i-1,j,dp)+findWays(i,j-1,dp);
    }
}