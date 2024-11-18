class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];

        if (k == 0) {
            Arrays.fill(ans, 0);
            return ans;
        }

        int[] presum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            presum[i + 1] = presum[i] + code[i];
        }

        if (k > 0) {
            for (int i = 0; i < n; i++) {
                int start = (i + 1) % n;
                int end = (i + k) % n;

                if (start <= end) {
                    ans[i] = presum[end + 1] - presum[start];
                } else {
                    ans[i] = (presum[n] - presum[start]) + presum[end + 1];
                }
            }
        }

        if (k < 0) {
            k = -k;
            for (int i = 0; i < n; i++) {
                int start = (i - k + n) % n;
                int end = (i - 1 + n) % n;

                if (start <= end) {
                    ans[i] = presum[end + 1] - presum[start];
                } else {
                    ans[i] = (presum[n] - presum[start]) + presum[end + 1];
                }
            }
        }

        return ans;
    }
}
