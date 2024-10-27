class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int c90=0,c180=0,c270=0,c0=0;
        for(int i =0;i< mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                int ri = j;
                int rj = i;
                if(mat[i][j]==target[ri][target.length - 1- rj]) c90++;
                if (mat[i][j] == target[target.length-1-i][target.length-1-j]) c180++;
                if (mat[i][j]== target[i][j]) c0++;
                if (mat[i][j] == target[target.length -1 -ri ][rj]) c270++;
            }
        }
        int c = mat.length* mat.length;
        return (c90==c ||c270==c || c0==c || c180==c);
    }
}