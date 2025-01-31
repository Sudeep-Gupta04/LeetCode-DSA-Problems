class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int[][] size = new int[n][n];
        boolean check = false;
        DSU dsu = new DSU(n*n);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    List<int[]> component = new ArrayList<>();
                    int c = dfsCount(i, j, vis, grid, n, component , dsu);
                    for (int[] cell : component) {
                        size[cell[0]][cell[1]] = c;
                    }
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==0){
                int tans =0;
                HashSet<Integer> hs = new HashSet<>();
                    check = true;
                    int[] x = {0, 1, 0, -1};
                    int[] y = {1, 0, -1, 0};
                    for(int k =0;k<4;k++){
                        int newx = i + x[k];
                        int newy = j + y[k];
                        if (newx < n && newy < n && newx >= 0 && newy >= 0 && grid[newx][newy]==1){
                            if(!hs.contains(dsu.findParent(newx*n+newy))){
                                hs.add(dsu.findParent(newx*n+newy));
                                tans+=size[newx][newy];
                            }
                        }
                    }
                     ans = Math.max(ans,tans+1);
                }
               
            }
        }
        if(!check) return n*n;
        return ans;
    }

    private static int dfsCount(int i, int j, boolean[][] vis, int[][] grid, int n, List<int[]> component,DSU dsu) {
        vis[i][j] = true;
        component.add(new int[]{i, j});
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        int ans = 1;

        for (int k = 0; k < 4; k++) {
            int newx = i + x[k];
            int newy = j + y[k];
            if (newx < n && newy < n && newx >= 0 && newy >= 0 && grid[newx][newy] == 1 && !vis[newx][newy]) {
                dsu.union(i*n+j,newx*n+newy);
                ans += dfsCount(newx, newy, vis, grid, n, component,dsu);
            }
        }
        return ans;
    }


    private void fill(int[][] size, int c, int i, int j, int n,boolean[][] temp,boolean[][] vis) {
        temp[i][j] = true;
        size[i][j] = c;
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        for(int k =0;k<4;k++){
            int newx = i+x[k];
            int newy = j+y[k];
            if(newx<n && newy<n && newx>=0 && newy>=0 && vis[newx][newy] && !temp[newx][newy]){
                fill(size,c,newx,newy,n,temp,vis);
            }
        }
    }

    private static int dfsCount(int i, int j, boolean[][] vis, int[][] grid, int n, List<int[]> component) {
        vis[i][j] = true;
        component.add(new int[]{i, j});
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};
        int ans = 1;

        for (int k = 0; k < 4; k++) {
            int newx = i + x[k];
            int newy = j + y[k];
            if (newx < n && newy < n && newx >= 0 && newy >= 0 && grid[newx][newy] == 1 && !vis[newx][newy]) {
                ans += dfsCount(newx, newy, vis, grid, n, component);
            }
        }
        return ans;
    }
}
class DSU {
    int[] rank;
    int[] ultp;

    public DSU(int nodes) {
        rank = new int[nodes];
        ultp = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            ultp[i] = i;
        }
    }

    public int findParent(int node) {
        if (ultp[node] == node) {
            return node;
        }
        return ultp[node] = findParent(ultp[node]);
    }

    public void union(int n1, int n2) {
        int p1 = findParent(n1);
        int p2 = findParent(n2);

        if (p1 != p2) {
            int r1 = rank[p1];
            int r2 = rank[p2];

            if (r1 > r2) {
                ultp[p2] = p1;
            } else if (r1 < r2) {
                ultp[p1] = p2;
            } else {
                ultp[p2] = p1;
                rank[p1]++;
            }
        }
    }
}