class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int max = 0;
        for(int i =0;i<matrix.length;i++){
            // for each row
            int ans = 1;
            for(int j =0;j<matrix.length;j++){
                // check for each row 
                if(i==j) continue;
                boolean check1 = false;
                for(int k =0;k<matrix[0].length;k++){
                    if(((matrix[i][k])^(matrix[j][k]))!=1){
                        check1 = true;
                        break;
                    }
                }
                if(!check1){
                    ans++;
                    continue;
                }
                boolean check2 = false;
                for(int k =0;k<matrix[0].length;k++){
                    if(matrix[i][k]!=matrix[j][k]){
                        check2 = true;
                        break;
                    }
                }
                if(!check2){
                    ans++;
                }
            }
            max = Integer.max(max,ans);
        }
        return max;
    }
}