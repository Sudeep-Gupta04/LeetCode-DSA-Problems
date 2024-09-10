class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0;
        int r = 1;
        int xor = nums[0];
        int sum = nums[0];
        int ans = 0;
    
        while(r<nums.length){
            sum+=nums[r];
            xor^=nums[r];
            while(xor!=sum){
                sum = sum - nums[l];
                xor = xor ^ nums[l];
                l++;
            }
            if(xor==sum){
                ans = Math.max(ans, r-l+1);
            }
            r++;
        }
        if(ans == 0) return 1;
        else return ans;
    }
}