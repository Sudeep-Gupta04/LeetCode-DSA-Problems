class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int mod = 12345;
        int m = grid.length; 
        int n = grid[0].length; 
        
        int[] pre = new int[m * n];
        int[] suf = new int[m * n];
        
        int k = 0;
        int p = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[k++] = p;
                p = ((p % mod) * (grid[i][j] % mod)) % mod;
            }
        }
        k = (m * n) - 1;
        p = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                suf[k--] = p;
                p = ((p % mod) * (grid[i][j] % mod)) % mod;
            }
        }

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int preidx = i * n + j;
                int sufidx = preidx;  
                grid[i][j] = (pre[preidx] % mod * suf[sufidx] % mod) % mod;
            }
        }

        return grid;
    }
}
