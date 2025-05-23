class Solution {
        public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        q.addFirst(new int[]{0, 0, 0});
        int x[] = {0, 0, 1, -1};
        int y[] = {1, -1, 0, 0};
        while(!q.isEmpty()){
            int[] t = q.removeFirst();
            int cost = t[0];
            int i = t[1];
            int j = t[2];
            if(i==n-1 && j==m-1) return cost;
            for (int k = 0; k < 4; k++) {
                int newx = i + x[k];
                int newy = j + y[k];
                if (newx >= 0 && newx < n && newy >= 0 && newy < m  && !vis[newx][newy]) {
                    if(grid[newx][newy]==1){
                        q.addLast(new int[]{cost+1,newx,newy});
                    }else{
                        q.addFirst(new int[]{cost,newx,newy});
                    }
                    vis[newx][newy] = true;
                }
            }
        }
        return n*m;
    }
}