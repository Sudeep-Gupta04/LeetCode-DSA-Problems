class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int s = 0;
        int e = r * c - 1;
        
        while (s <= e) {
            int mid = (s + e) / 2;
            int x = mid / c; 
            int y = mid % c; 
            
            if (matrix[x][y] == target) return true;
            else if (matrix[x][y] > target) e = mid - 1;
            else s = mid + 1;
        }
        
        return false;
    }
}