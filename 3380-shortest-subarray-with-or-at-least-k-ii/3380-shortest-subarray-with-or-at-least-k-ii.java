public class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        if(k==0) return 1;
        int[] bit = new int[32];
        int l = 0;
        int r = 0;
        int length = Integer.MAX_VALUE;

        while (r < nums.length) {
            int temp = 1;
            int num = nums[r];
            int idx = 31;

            for (int i = 0; i < Integer.SIZE; i++) {
                if ((num & temp) != 0 && idx >= 0 && idx < 32) bit[idx]++;
                temp <<= 1;
                idx--;
            }

            int res = 0;
            for (int i = 0; i < 32; i++) {
                if (bit[i] > 0) {
                    res += (1 << (31 - i));
                }
            }

            while (res >= k) {
                length = Math.min(length, r - l + 1);

                if (l < nums.length) {  // Ensure we don't go out of bounds when accessing nums[l]
                    int lnum = nums[l];
                    int lidx = 31;
                    int rtemp = 1;
                    for (int i = 0; i < Integer.SIZE; i++) {
                        if ((lnum & rtemp) != 0 && lidx >= 0 && lidx < 32) {
                            if (bit[lidx] != 0) bit[lidx]--;
                        }
                        rtemp <<= 1;
                        lidx--;
                    }
                    l++;
                }

                res = 0;
                for (int i = 0; i < 32; i++) {
                    if (bit[i] > 0) {
                        res += (1 << (31 - i));
                    }
                }
            }
            r++;
        }

        if (length == Integer.MAX_VALUE) return -1;
        else return length;
    }
}
