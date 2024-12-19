class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int r = 0, l = 0;
        HashSet<Integer> hs = new HashSet<>();
        long sum = 0;
        long ans = 0;

        while (r < nums.length) {
            if (hs.contains(nums[r])) {
                while (nums[l] != nums[r]) {
                    sum -= nums[l];
                    hs.remove(nums[l]);
                    l++;
                }
                sum -= nums[l];
                hs.remove(nums[l]);
                l++;
            }

            hs.add(nums[r]);
            sum += nums[r];

            if (hs.size() == k) {
                ans = Math.max(ans, sum);
                sum -= nums[l];
                hs.remove(nums[l]);
                l++;
            }

            r++;
        }

        return ans;
    }
}
