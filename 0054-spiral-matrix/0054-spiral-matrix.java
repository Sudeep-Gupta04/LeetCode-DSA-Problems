class Solution {
     public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new ArrayList<>();
        int low = 0;
        int high = matrix.length-1;
        int start = 0;
        int end = matrix[0].length-1;
        while(low<=high && start<=end){
            computeBoundary(l,low,high,start,end,matrix);
            low++;high--;
            start++;end--;
        }
        return l;
    }

    private void computeBoundary(List<Integer> l, int low, int high, int start, int end,int[][] mat) {
        for(int i =start;i<=end;i++){
            l.add(mat[low][i]);
        }
        for(int i = low+1;i<= high;i++){
            l.add(mat[i][end]);
        }
        if(low<high){
            for(int i = end-1;i>=start;i--){
            l.add(mat[high][i]);
            }    
        }
        if(start<end){
            for(int i = high-1;i>= low+1;i--){
            l.add(mat[i][start]);
         }
        }  
    }
}