public class Point {
    public int x; // x-coordinate
    public int y; // y-coordinate

     Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<Point> q = new LinkedList<>();
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Point(i,j));
                    vis[i][j] = true;
                }
            }
        }
        int c = -1;
        while(true){
            if(q.isEmpty()) break;
            c++;
            int size = q.size();
            for(int i =0;i<size;i++){
                int [] row = {-1,0,1,0};
                int [] col = {0,1,0,-1};
                Point p = q.remove();
                for(int k =0;k<row.length;k++){
                    int x = p.x+row[k];
                    int y = p.y+col[k];
                    if(x>=grid.length || x<0 || y>=grid[0].length || y<0 || grid[x][y]==0 || vis[x][y]==true
                    ) continue;
                    else {
                        grid[x][y] = 2;
                        vis[x][y] = true;
                        q.add(new Point(x,y));
                    }
                }
            }
        }
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        if(c==-1) return 0;
        return c;
    }
}