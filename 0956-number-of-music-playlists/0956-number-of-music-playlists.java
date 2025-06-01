class Solution {
    static final int MOD = 1_000_000_007;
    int mod = (int)1e9 + 7;
    int gluniq;
    long[][] dp;
    public int numMusicPlaylists(int n, int goal, int k) {
        dp = new long[goal+1][n+1];
        for(int i =0;i<goal+1;i++){
            Arrays.fill(dp[i],-1);
        }
        gluniq = n;
        return helper(goal, n, k);
    }

    public int helper(int goal, int uniq, int k) {
        if (goal == 0 && uniq == 0) return 1;
        if (goal == 0 && uniq != 0) return 0;
        if(dp[goal][uniq]!=-1) return (int) dp[goal][uniq];
        int ans = 0;

        if (uniq != 0) {
            ans = (int)((ans + ((long)uniq * helper(goal - 1, uniq - 1, k)) % mod) % mod);
        }

        int placed = gluniq - uniq;
        if (placed - k > 0) {
            ans = (int)((ans + ((long)(placed - k) * helper(goal - 1, uniq, k)) % mod) % mod);
        }
        dp[goal][uniq] = ans % mod;
        return (int) dp[goal][uniq];
    }
}
