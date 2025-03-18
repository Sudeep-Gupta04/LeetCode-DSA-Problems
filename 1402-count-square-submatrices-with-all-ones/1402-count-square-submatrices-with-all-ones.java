class Solution {
    public int countSquares(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                int d = 0;int l = 0;int u =0;
                if(matrix[i][j]==1){
                    if(i>0 && j>0)  d = ans[i-1][j-1];
                    if(j>0) l = ans[i][j-1];
                    if(i>0) u = ans[i-1][j];
                    ans[i][j] = Math.min(l,Math.min(u,d)) + 1;
                }
            }
        }
        int s =0;
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                s+=ans[i][j];
            }
        }
        return s;
    }
}