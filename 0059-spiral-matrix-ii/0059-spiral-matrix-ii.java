class Solution {
    int x  = 1;
    
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int low = 0;
        int high = mat.length-1;
        int start = 0;
        int end = mat[0].length-1;
        while(low<=high && start<=end){
            fillBoundary(low,high,start,end,mat);
            low++;
            high--;
            end--;
            start++;
        }
        return mat;
    }
    private void fillBoundary( int low, int high, int start, int end,int[][] mat) {
        for (int i = start; i <= end; i++) {
            mat[low][i] = x++;
            ;
        }
        for (int i = low + 1; i <= high; i++) {
            mat[i][end] = x++;
        }
        if (low < high) {
            for (int i = end - 1; i >= start; i--) {
                mat[high][i] = x++;
            }
        }
        if (start < end) {
            for (int i = high - 1; i >= low + 1; i--) {
                mat[i][start] = x++;
            }
        }
    }
}