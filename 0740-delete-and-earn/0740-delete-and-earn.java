class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num] += num;
        }
        int[] dp = new int[maxVal + 1];
        dp[0] = 0;
        dp[1] = freq[1];

        for (int i = 2; i <= maxVal; i++) {
            dp[i] = Math.max(freq[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[maxVal];
    }
}
