class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        int fans = Integer.MIN_VALUE;
        int[][] dp = initializeMatrix(matrix.length,matrix[0].length,-1);
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
               int ans = findWay(matrix,vis,i,j,dp);
               fans = Math.max(fans,ans);
            }
        }

        return fans+1;
    }
    public int[][] initializeMatrix(int rows, int cols, int value) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value;
            }
        }

        return matrix;
    }

   private int findWay(int[][] matrix, boolean[][] vis,int r,int c,int[][] dp) {
        if(r<0 || c<0 || r>= vis.length || c>= vis[0].length || vis[r][c]){
            return 0;
        }
        if(dp[r][c]!=-1) return dp[r][c];
        vis[r][c]=true;
        int ans1 = 0;
        if(r-1>=0 && matrix[r-1][c]>matrix[r][c]) {
            ans1 = 1+findWay(matrix,vis,r-1,c,dp);
        }
        int ans2 = 0;
        if(r+1<matrix.length && matrix[r+1][c]>matrix[r][c]) {
            ans2 = 1+findWay(matrix,vis,r+1,c,dp);
        }
        int ans3 = 0;
        if(c-1>=0 && matrix[r][c-1]>matrix[r][c]) {
            ans3 = 1+findWay(matrix,vis,r,c-1,dp);
        }
        int ans4 = 0;
        if(c+1< matrix[0].length && matrix[r][c+1]>matrix[r][c]) {
            ans4 = 1+findWay(matrix,vis,r,c+1,dp);
        }
        vis[r][c]= false;
        return dp[r][c] = Math.max(Math.max(ans1,ans2),Math.max(ans3,ans4));
    }
}