
class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] ans = new int[mat.length][mat[0].length];
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        Queue<Point> q = new ArrayDeque<>();
        for(int i =0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++){
                if(mat[i][j]==0) {
                    vis[i][j] = true;
                    q.add(new Point(i,j));
                }
            }
        }
        while (!q.isEmpty()){
            Point p = q.remove();
            int [] row = {-1,0,1,0};
            int [] col = {0,1,0,-1};
            for(int k=0;k<row.length;k++){
                int x = p.x+row[k];
                int y = p.y+col[k];
                if(x<0 || y<0 || x>=mat.length || y>=mat[0].length || vis[x][y]) continue;
                ans[x][y] = ans[p.x][p.y]+1;
                vis[x][y]  = true;
                q.add(new Point(x,y));
            }
        }
        return ans;
    }

}
