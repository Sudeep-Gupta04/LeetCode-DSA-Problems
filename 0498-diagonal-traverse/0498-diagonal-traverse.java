class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int k = 0;

        if (m == 1) {
            for (int j = 0; j < n; j++) {
                ans[k++] = mat[0][j];
            }
            return ans;
        } else if (n == 1) {
            for (int i = 0; i < m; i++) {
                ans[k++] = mat[i][0];
            }
            return ans;
        }

        
        for (int q = 0; q < m + n - 1; q++) {
            if (q % 2 == 0) {
                int i = Math.min(q, m - 1);
                int j = q - i;
                while (i >= 0 && j < n) {
                    ans[k++] = mat[i][j];
                    i--;
                    j++;
                }
            } else { 
                int j = Math.min(q, n - 1);
                int i = q - j;
                while (j >= 0 && i < m) {
                    ans[k++] = mat[i][j];
                    i++;
                    j--;
                }
            }
        }
        return ans;
    }
}
