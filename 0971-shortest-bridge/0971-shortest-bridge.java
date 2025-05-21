class Solution {
    Queue<int[]> q;
    boolean[][] vis;
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        q = new ArrayDeque<>();
        vis = new boolean[n][m];
        int c =0;
        for(int i =0;i<n;i++){
            if(c==1) break;
            for(int j =0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,n,m);
                    c=1;
                    break;
                }
            }
        }
        System.out.println(q.size());
        int lv = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                int[] num = q.poll();
                if(grid[num[0]][num[1]]==1 && lv!=0) return lv-1;
                int x[] = {-1, 0, 1, 0};
                int y[] = {0, 1, 0, -1};

                for(int k=0;k<4;k++){
                    int newx = num[0] + x[k];
                    int newy = num[1] + y[k];
                    if (newx >= 0 && newx < n && newy >= 0 && newy < m && !vis[newx][newy] ) {
                        vis[newx][newy] = true;
                        q.add(new int[]{newx,newy});
                    }
                }
            }
            lv++;
        }
        return -1;
    }
    private void dfs(int[][] land, int i, int j, int n, int m) {
        vis[i][j] = true;
        q.add(new int[]{i,j});
        int x[] = {-1, 0, 1, 0};
        int y[] = {0, 1, 0, -1};

        for(int k=0;k<4;k++){
            int newx = i + x[k];
            int newy = j + y[k];
            if (newx >= 0 && newx < n && newy >= 0 && newy < m && !vis[newx][newy] && land[newx][newy] == 1) {
                dfs(land,newx,newy,n,m);
            }
        }
        return;
    }
}