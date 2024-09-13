class Solution {
   public boolean check(int[] nums) {
        int idx = -1;
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                idx = i-1;
            }
            if (count > 1) {
                    return false; 
                }
        }
        if (idx != -1) {
            for (int i = idx + 1; i < nums.length; i++) {
                if (nums[i] > nums[0]) {
                    return false;  
                }
            }
        }
        return true; 
    }
}
 