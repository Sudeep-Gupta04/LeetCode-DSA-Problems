class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        mat = new int[n][m];
        mat[0][0]= matrix[0][0];
        for(int i =1;i<m;i++){
            mat[0][i] = mat[0][i-1] + matrix[0][i];
        }
        for(int i =1;i<n;i++){
            mat[i][0] = mat[i-1][0] + matrix[i][0];
        }
        for(int i =1;i<n;i++){
            for(int j = 1;j<m;j++){
                mat[i][j] = mat[i-1][j] +mat[i][j-1] - mat[i-1][j-1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int lsum =0,rsum =0,dsum =0;
        int Tsum = mat[row2][col2];
        if(col1!=0)  lsum = mat[row2][col1-1];
        if(row1!=0)  rsum = mat[row1-1][col2];
        if(col1!=0 && row1!=0) dsum = mat[row1-1][col1-1];
        return Tsum - lsum - rsum + dsum; 
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */