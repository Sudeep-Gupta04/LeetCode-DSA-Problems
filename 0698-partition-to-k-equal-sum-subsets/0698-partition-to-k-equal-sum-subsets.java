public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % k != 0) {
            return false;
        }

        //Arrays.sort(nums);
        int targetBucketSum = total / k;
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, visited, 0, k, 0, targetBucketSum);
    }

    private boolean canPartition(int[] nums, boolean[] visited, int start, int k, int bucketSum, int targetBucketSum) {
        if (k == 0) {
            return true;
        }
        if (bucketSum == targetBucketSum) {
            return canPartition(nums, visited, 0, k - 1, 0, targetBucketSum);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] || bucketSum + nums[i] > targetBucketSum) {
                continue;
            }
            visited[i] = true;
            if (canPartition(nums, visited, i + 1, k, bucketSum + nums[i], targetBucketSum)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
