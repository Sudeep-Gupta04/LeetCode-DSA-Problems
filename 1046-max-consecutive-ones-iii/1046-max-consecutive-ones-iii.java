class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int count0 = 0;
        int maxLength = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                count0++;
            }

            if (count0 > k) {
                if (nums[l] == 0) {
                    count0--;
                }
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }

        return maxLength;
    }
}