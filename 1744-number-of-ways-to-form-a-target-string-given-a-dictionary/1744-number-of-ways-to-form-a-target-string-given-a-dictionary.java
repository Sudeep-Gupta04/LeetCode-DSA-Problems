class Solution {
    int mod = (int)1e9 + 7;
    int n, m;
    HashMap<String, Integer> dp;

    public int numWays(String[] words, String target) {
        this.n = words.length;
        this.m = words[0].length();
        dp = new HashMap<>();

        int[][] hs = new int[m][26];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                char ch = words[i].charAt(j);
                hs[j][ch - 'a']++;
            }
        }

        return helper(0, 0, hs, target);
    }

    private int helper(int i, int j, int[][] hs, String tar) {
        if (j >= tar.length()) return 1;
        if (i >= m) return 0;

        String key = i + "," + j;
        if (dp.containsKey(key)) return dp.get(key);

        int ans = 0;
        int freqAtI = hs[i][tar.charAt(j) - 'a'];

        if (freqAtI > 0) {
            ans = (int)((ans + (1L * freqAtI * helper(i + 1, j + 1, hs, tar)) % mod) % mod);
        }

        ans = (ans + helper(i + 1, j, hs, tar)) % mod;
        dp.put(key, ans);
        return ans;
    }
}
