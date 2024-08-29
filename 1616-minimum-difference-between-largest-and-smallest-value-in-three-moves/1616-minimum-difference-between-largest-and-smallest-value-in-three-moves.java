class Solution {
     int p; int q;
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(nums.length<=4) return 0;
        p = 0;
        q = nums.length-1;
        Arrays.sort(nums);
        int p1 = nums[n-1-3] - nums[0];
        int p2 = nums[n-1] - nums[3];
        int p3 = nums[n-1-2] - nums[1];
        int p4 = nums[n-1-1] - nums[2];
        return Math.min(Math.min(p1,p2),Math.min(p3,p4));
    }

    private void shift(int p, int q, int[] nums) {
        while (p < nums.length - 1 && nums[p] == nums[p + 1]) {
        p++;
        }
        while (q > 0 && nums[q] == nums[q - 1]) {
        q--;
        }
    }
}