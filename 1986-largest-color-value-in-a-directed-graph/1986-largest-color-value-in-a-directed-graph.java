class Solution {
    int[][] dp;
    List<Integer>[] graph;
    int[] visited;
    boolean isCyclic = false;

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        dp = new int[n][26];
        graph = new List[n];
        visited = new int[n];
        Arrays.fill(visited, -1);

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : edges) graph[e[0]].add(e[1]);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int res = dfs(i, colors);
            if (isCyclic) return -1;
            ans = Math.max(ans, res);
        }
        return ans;
    }

    private int dfs(int node, String colors) {
        if (visited[node] == 0) {
            isCyclic = true;
            return 0;
        }
        if (visited[node] == 1) {
            return getMax(dp[node]);
        }

        visited[node] = 0;
        for (int nei : graph[node]) {
            int[] childDp = dp[nei];
            int val = dfs(nei, colors);
            for (int c = 0; c < 26; c++) {
                dp[node][c] = Math.max(dp[node][c], childDp[c]);
            }
        }

        dp[node][colors.charAt(node) - 'a']++;
        visited[node] = 1;

        return getMax(dp[node]);
    }

    private int getMax(int[] arr) {
        int max = 0;
        for (int val : arr) max = Math.max(max, val);
        return max;
    }
}
