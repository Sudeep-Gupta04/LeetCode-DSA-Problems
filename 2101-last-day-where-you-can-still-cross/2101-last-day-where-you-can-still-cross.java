public class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // For using Point as key in HashSet/HashMap
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point p = (Point) obj;
        return this.x == p.x && this.y == p.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    // Optional: for readable debugging
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
class Solution {
        public int latestDayToCross(int row, int col, int[][] cells) {
        int n = cells.length;
        HashMap<Point, Integer> hs = new HashMap<>();
        for(int i =0;i<n;i++){
            hs.put(new Point(cells[i][0]-1,cells[i][1]-1),i);
        }
       
        int s = 0; int e = n-1;
        while(s<=e){
            int mid  = (s+e)/2;
            if(isValid(mid,hs,row,col)) s = mid +1;
            else e = mid - 1;
        }
        return e+1;
    }

    public boolean isValid(int mid, HashMap<Point,Integer> hm, int row, int col){
        boolean[][] vis = new boolean[row][col];
        Queue<Point> q = new ArrayDeque<>();
        for(int i =0;i<col;i++){
            Point p = new Point(0,i);
            if(hm.containsKey(p) && hm.get(p)<=mid){

            }
            else{
                q.add(p);
                vis[0][i] = true;
            }
        }
        int[] x = {-1,0,1,0};
        int[] y = {0,1,0,-1};
        while(!q.isEmpty()){
            Point p = q.remove();
            for(int i =0;i<4;i++){
                int newx = p.x+x[i];
                int newy = p.y+y[i];
                if(newx <row && newx>=0 && newy<col && newy>=0 && !vis[newx][newy]){
                    Point newp = new Point(newx, newy);
                    if(hm.containsKey(newp) && hm.get(newp)<=mid){

                    }else {
                        q.add(newp);
                        vis[newx][newy] = true;
                    }
                }
            }
        }
        for(int i =0;i<col;i++){
            if(vis[row-1][i]) return true;
        }
        return false;
    }
}