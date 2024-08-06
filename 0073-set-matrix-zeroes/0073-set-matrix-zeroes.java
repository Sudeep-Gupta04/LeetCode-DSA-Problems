class Solution {
       public static int[][] setZeroes(int[][] matrix) {
        ArrayList al = new ArrayList();
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    al.add(i);
                    al.add(j);
                }
            }
        }
        for(int i =0;i<al.size()-1;i+=2){
            for(int k=0;k<matrix[0].length;k++){
                matrix[(int)al.get(i)][k]=0;
            }
            for (int q =0;q< matrix.length;q++){
                matrix[q][(int)al.get(i+1)]=0;
            }
        }
        return matrix;
    }
}