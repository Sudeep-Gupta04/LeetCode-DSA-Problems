
class Pair implements Comparable<Pair> {
    int[] x;int y;

    Pair(int[] x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair other) {
        return 0; // No priority logic added since original code didn't specify it
    }
}
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int keys = 0;
        int n = grid.length;
        int m = grid[0].length();
        int tmask = (int) Math.pow(2,6);
        int[][][] dp = new int[grid.length][grid[0].length()][tmask];
        boolean[][][] vis = new boolean[n][m][tmask];
        Queue<Pair> q = new ArrayDeque<>();
        for(int i =0;i<n;i++){
            StringBuilder s = new StringBuilder(grid[i]);
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='@'){
                    q.add(new Pair(new int[]{i,j},0));
                    vis[i][j][0] = true;
                }
                if((int)s.charAt(j)>=97 && (int)s.charAt(j)<=102) keys++;
            }
        }
        int fmask = (1<<keys) - 1;
        int lv = 0;
        int[] x = {-1,0,1,0};
        int[] y = {0,1,0,-1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                Pair p = q.remove();
                int previ = p.x[0];
                int prevj = p.x[1];
                int mask = p.y;
                if(mask == fmask) return lv;

                for(int j = 0;j<4;j++){
                    int newx = previ + x[j];
                    int newy = prevj + y[j];

                    if(newx<n && newy<m && newx>=0 && newy>=0 && grid[newx].charAt(newy)!='#' ){
                        // for lock
                        if((int)grid[newx].charAt(newy)>= 65 &&  (int)grid[newx].charAt(newy)<= 70){
                            int idx = grid[newx].charAt(newy) - 65;
                            if((mask & (1<<idx))!=0 && !vis[newx][newy][mask]) {
                                q.add(new Pair(new int[]{newx, newy}, mask));
                                vis[newx][newy][mask] = true;
                            }
                        }// for key 
                        else if ((int)grid[newx].charAt(newy)>= 97 &&  (int)grid[newx].charAt(newy)<= 102) {
                            int idx = grid[newx].charAt(newy) - 97;
                            int newmask = (mask | (1<<idx));
                            if(!vis[newx][newy][newmask]) {
                                vis[newx][newy][newmask] = true;
                                q.add(new Pair(new int[]{newx, newy}, newmask));
                            }
                        }// for simple path
                        else{
                            if(!vis[newx][newy][mask]){
                                vis[newx][newy][mask] = true;
                                q.add(new Pair(new int[]{newx, newy}, mask));
                            }
                        }
                    }
                }
            }
            lv++;
        }
        return -1;
    }
}