class Solution {
    public int minOperations(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
        return 0;
    }
    int count = 0;

    for (int i = 0; i < nums.length - 1; i++) {
        int current = nums[i + 1];
        int previous = nums[i];

        if (current <= previous) {
            int minCurrent = Math.max(previous + 1, current);
            count += minCurrent - current;
            nums[i + 1] = minCurrent;
        }
    }
    return count;

    }
}