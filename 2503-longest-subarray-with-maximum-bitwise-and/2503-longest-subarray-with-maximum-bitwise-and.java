class Solution {
    public int longestSubarray(int[] nums) {
        int l = 0;
        int maxVal = 0; 
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                l = i;
            }
        }
        
        int r = l + 1;
        if(r>=nums.length) return 1;
        int and = nums[l];
        int maxLength = 1;

        while (r < nums.length) {
            if (nums[r]==maxVal && nums[l]==maxVal) { 
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
            }else{
                l = r;
                r++;
            }
        }

        return maxLength;
    }
}
