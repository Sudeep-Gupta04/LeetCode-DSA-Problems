class Solution {
    boolean[][] vis = new boolean[300][300];
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        List<int[]> ans = new ArrayList<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(!vis[i][j] && land[i][j]==1){
                    int[] t = new int[4];
                    t[0] = i;t[1]=j;
                    int[] a = dfs(land,i,j,n,m);
                    t[2] = a[0]; t[3]=a[1];
                    ans.add(t);
                }
            }
        }
        return ans.toArray(new int[0][]);
    }

    private int[] dfs(int[][] land, int i, int j, int n, int m) {
        vis[i][j] = true;
        int x[] = {-1, 0, 1, 0};
        int y[] = {0, 1, 0, -1};

        int maxx = i;
        int maxy = j;
        for(int k=0;k<4;k++){
            int newx = i + x[k];
            int newy = j + y[k];
            if (newx >= 0 && newx < n && newy >= 0 && newy < m && !vis[newx][newy] && land[newx][newy] == 1) {
                int[] ans = dfs(land,newx,newy,n,m);
                maxx = Math.max(maxx,ans[0]);
                maxy = Math.max(maxy,ans[1]);
            }
        }
        return new int[]{maxx,maxy};
    }
}