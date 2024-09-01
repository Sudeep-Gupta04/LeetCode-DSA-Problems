class Solution {
    public int sumOfBeauties(int[] nums) {
        int[] p = new int[nums.length];
        int[] s = new int[nums.length];
        
        int max1 = nums[0];
        p[0] = max1;
        for (int i = 1; i < p.length; i++) {
            max1 = Math.max(max1, nums[i]);
            p[i] = max1;
        }
        
        int min1 = nums[nums.length - 1];
        s[nums.length - 1] = min1;
        for (int i = s.length - 2; i >= 0; i--) {
            min1 = Math.min(min1, nums[i]);
            s[i] = min1;
        }
        
        int beaut = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (p[i - 1] < nums[i] && nums[i] < s[i + 1]) beaut += 2;
            else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) beaut += 1;
        }
        return beaut;
    }
}
