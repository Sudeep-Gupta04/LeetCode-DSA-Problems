class Solution {
    public long maxMatrixSum(int[][] matrix) {
       // int mi =0;int mj =0;
        int min = Integer.MAX_VALUE;
        int c = 0;
        long ans =0;
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]<0){
                    c++;
                    matrix[i][j] = -1*matrix[i][j]; 
                }
                ans += matrix[i][j];
                if(matrix[i][j]<min){
                    min = matrix[i][j];
                }
            }
        } 
        if(c%2!=0){
            ans = ans - 2*min;
        }   
        return ans;
    }
}