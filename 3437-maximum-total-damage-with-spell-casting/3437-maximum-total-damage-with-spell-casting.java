class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        long[] dp = new long[power.length];
        Arrays.fill(dp, -1);
        return helper(power, dp, 0);
    }

    public long helper(int[] power, long[] dp, int curidx) {
        int n = power.length;
        if (curidx >= n) return 0;
        if (dp[curidx] != -1) return dp[curidx];

        int curpower = power[curidx];
        long sum = 0;
        int idx = curidx;

        while (idx < n && power[idx] == curpower) {
            sum += curpower;
            idx++;
        }

        int nt = idx;

        
        while (idx < n && power[idx] <= curpower + 2) {
            idx++;
        }

        long p1 = sum + helper(power, dp, idx);
        long p2 = helper(power, dp, nt);

        return dp[curidx] = Math.max(p1, p2);
    }
}
