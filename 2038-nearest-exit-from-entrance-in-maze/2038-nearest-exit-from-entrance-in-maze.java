class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new ArrayDeque<>();
        int n = maze.length;
        int m = maze[0].length;
        q.add(new int[]{entrance[0],entrance[1]});
        int lv =0;
        int x[] = {-1, 0, 1, 0};
        int y[] = {0, 1, 0, -1};
        boolean[][] vis = new boolean[n][m];

        while(!q.isEmpty()){
            int size = q.size();
            for(int z=0;z<size;z++){
                int[] nod = q.poll();
                int i = nod[0];
                int j = nod[1];
                if((i==n-1 || i==0 || j==m-1 || j==0) && !(i==entrance[0] && j==entrance[1])) return lv;
                for(int k=0;k<4;k++){
                    int newx = i + x[k];
                    int newy = j + y[k];
                    if (newx >= 0 && newx < n && newy >= 0 && newy < m && !vis[newx][newy] && maze[newx][newy] == '.') {
                        vis[newx][newy] = true;
                        q.add(new int[]{newx,newy});
                    }
                }
            }
            lv++;
        }
        return -1;
    }
}