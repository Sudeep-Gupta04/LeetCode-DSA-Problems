class Solution {
    int mod = (int)1e9+7;
    long[][] dpmax;
    long[][] dpmin;
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        dpmax = new long[n][m];
        dpmin = new long[n][m];
        for(long[] i:dpmax) Arrays.fill(i,Long.MIN_VALUE);
        for(long[] i:dpmin) Arrays.fill(i,Long.MAX_VALUE);
        long ans = helpermax(0,0,n,m,grid);
        return (ans<0)?-1:(int)(ans%mod);
    }

    private long helpermin(int i, int j, int n, int m, int[][] grid) {
        if(dpmin[i][j]!=Long.MAX_VALUE) return dpmin[i][j];
        if(i==n-1 && j==m-1) return dpmin[i][j] = grid[i][j];

        long p1 = Long.MAX_VALUE; long p2 =Long.MAX_VALUE;
        long p3 = Long.MAX_VALUE; long p4 =Long.MAX_VALUE;
        if(i+1<n){
            p1 = grid[i][j]*helpermin(i+1,j,n,m,grid);
            p2 = grid[i][j]*helpermax(i+1,j,n,m,grid);
        }
        if(j+1<m) {
            p3 = grid[i][j]*helpermin(i,j+1,n,m,grid);
            p4 = grid[i][j]*helpermax(i,j+1,n,m,grid);
        }
        return dpmin[i][j] = Math.min(Math.min(p1,p2),Math.min(p3,p4));
    }

    public long helpermax(int i, int j,int n, int m,int[][] grid){
        if(dpmax[i][j]!=Long.MIN_VALUE) return dpmax[i][j];
        if(i==n-1 && j==m-1) return dpmax[i][j] = grid[i][j];

        long p1 = Long.MIN_VALUE; long p2 =Long.MIN_VALUE;
        long p3 = Long.MIN_VALUE; long p4 =Long.MIN_VALUE;
        if(i+1<n){
            p1 = grid[i][j]*helpermin(i+1,j,n,m,grid);
            p2 = grid[i][j]*helpermax(i+1,j,n,m,grid);
        }
        if(j+1<m) {
            p3 = grid[i][j]*helpermin(i,j+1,n,m,grid);
            p4 = grid[i][j]*helpermax(i,j+1,n,m,grid);
        }
        return dpmax[i][j] = Math.max(Math.max(p1,p2),Math.max(p3,p4));
    }
}