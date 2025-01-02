

public class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); // Sort the array for efficient counting
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Find the range of valid pairs for nums[i]
            int left = lower - nums[i];
            int right = upper - nums[i];

            // Use binary search to find the range
            int start = lowerBound(nums, i + 1, n - 1, left);
            int end = upperBound(nums, i + 1, n - 1, right);

            if (start <= end) {
                count += (end - start + 1); // Count valid pairs
            }
        }

        return count;
    }

    // Find the first index >= target in the range [low, high]
    private int lowerBound(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // Find the last index <= target in the range [low, high]
    private int upperBound(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}