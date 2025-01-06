class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> al = new ArrayList<>();
        int[][] dp = new int[m][n]; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] ans = new int[2];
                boolean[][] vis = new boolean[m][n];
                dfs(ans, heights, vis, i, j, dp, false);
                if (ans[0] == 1 && ans[1] == 1) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    al.add(temp);
                    dp[i][j] = 2; 
                } else {
                    dp[i][j] = 1; 
                }
            }
        }
        return al;
    }

    private void dfs(int[] ans, int[][] heights, boolean[][] vis, int i, int j, int[][] dp, boolean flag) {

        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || vis[i][j]) return;
        //if(dp[i][j] == 1) return;
        if(dp[i][j] == 2){
            flag = true;
            ans[0]=1;
            ans[1]=1;
            return;
        }
        vis[i][j] = true;
        if (i == 0 || j == 0) ans[0] = 1; 
        if (i == heights.length - 1 || j == heights[0].length - 1) ans[1] = 1;
        int[] x = {0, +1, 0, -1};
        int[] y = {-1, 0, +1, 0};
        for (int k = 0; k < 4; k++) {
            int newx = i + x[k];
            int newy = j + y[k];
            if (newx >= 0 && newy >= 0 && newx < heights.length && newy < heights[0].length 
                && !vis[newx][newy] && heights[newx][newy] <= heights[i][j]) {
                dfs(ans, heights, vis, newx, newy, dp, flag);
                if(flag) return;
            }
        }
    }
}
