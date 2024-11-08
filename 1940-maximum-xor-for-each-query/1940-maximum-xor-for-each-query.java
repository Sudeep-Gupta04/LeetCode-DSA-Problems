class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int xor = 0;
        for(int i =0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        int rem = (1<< maximumBit) -1 ;
        int[] ans = new int[nums.length];
        ans[0] = xor ^ rem;
        int k = 1;
        for(int i = nums.length-1;i>=1;i--){
            xor = xor^nums[i];
            ans[k++]= xor ^ rem;
        }
        return ans;
    }
}