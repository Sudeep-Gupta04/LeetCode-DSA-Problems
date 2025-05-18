class Solution {
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int chances = 5 * n;
        int[][][] dp = new int[n][n][chances];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], -1);

        return solve(graph, dp, 0, 1, 2, chances);
    }

    public int solve(int[][] graph, int[][][] dp, int chance, int m, int c, int Maxchances) {
        if (chance >= Maxchances) return 0; 
        if (m == c) return 2;             
        if (m == 0) return 1;              

        if (dp[m][c][chance] != -1) return dp[m][c][chance];

        boolean draw = false;
        int ans;

        //mouse turn
        if (chance % 2 == 0) {
            for (int next : graph[m]) {
                ans = solve(graph, dp, chance + 1, next, c, Maxchances);
                if (ans == 1) return dp[m][c][chance] = 1; 
                if (ans == 0) draw = true;
            }
            if (draw) return dp[m][c][chance] = 0;
            return dp[m][c][chance] = 2; 
        } 
        // cat turn
        else {
            for (int next : graph[c]) {
                if (next == 0) continue;
                ans = solve(graph, dp, chance + 1, m, next, Maxchances);
                if (ans == 2) return dp[m][c][chance] = 2;
                if (ans == 0) draw = true;
            }
            if (draw) return dp[m][c][chance] = 0;
            return dp[m][c][chance] = 1; 
        }
    }
}