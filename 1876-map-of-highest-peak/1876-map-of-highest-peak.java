class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;int m = isWater[0].length;
        int[][] ans = new int[n][m];
        Queue<Point> q = new ArrayDeque<>();
        HashSet<Point> hs = new HashSet<>();
        for(int i =0;i<isWater.length;i++){
            for(int j =0;j<isWater[0].length;j++){
                if(isWater[i][j]==1) {
                    hs.add(new Point(i,j));
                    q.add(new Point(i,j));
                }
            }
        }
        while(!q.isEmpty()){
            Point p = q.remove();
            int[] x = {0,+1,0,-1};
            int[] y = {1,0,-1,0};
            for(int i =0;i<4;i++){
                int newx = p.x+x[i];
                int newy = p.y+y[i];
                if((newx<0) || (newx>=n) || (newy<0) || (newy>=m)) continue;
                else if(ans[newx][newy]==0 && !hs.contains(new Point(newx,newy))){
                    ans[newx][newy] = 1+ans[p.x][p.y];
                    q.add(new Point(newx,newy));
                }
            }
        }
    return ans;
    }
}
class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}