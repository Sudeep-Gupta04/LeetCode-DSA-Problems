
public class Solution {
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        
        if (nums[0] <= target) {
            prev[nums[0]] = true;
        }
        
        for (int i = 1; i < nums.length; i++) {
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for (int j = 1; j <= target; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (nums[i] <= j) {
                    take = prev[j - nums[i]];
                }
                curr[j] = take || notTake;
            }
            prev = curr.clone();
        }
        
        return prev[target];
    }
}