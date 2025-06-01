class Solution {
    int[][] dp;
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        dp = new int[n][m + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        dp[0][0] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int rIdx = cur[0];
            int kIdx = cur[1];
            int cost = dp[rIdx][kIdx];

            if(kIdx<m && ring.charAt(rIdx)==key.charAt(kIdx)){
                if(dp[rIdx][kIdx+1]>cost+1){
                    dp[rIdx][kIdx+1] = cost +1;
                    q.add(new int[]{rIdx,kIdx+1});
                }
            }else{
                // clockise wise
                int newrIdx = (rIdx+1)%n;
                if(dp[newrIdx][kIdx]>cost+1){
                    dp[newrIdx][kIdx] = cost +1;
                    q.add(new int[]{newrIdx,kIdx});
                }
                // anticlock wise
                int antnewIdx = (rIdx-1+n)%n;
                if(dp[antnewIdx][kIdx]>cost+1){
                    dp[antnewIdx][kIdx] = cost +1;
                    q.add(new int[]{antnewIdx,kIdx});
                }
            }

        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i][m]);
        }
        return ans;
    }
}
