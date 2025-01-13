class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int xor = 0;
        Arrays.sort(nums);
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) {
                xor ^= nums[i];
                i++;
            }
            
        }
        return xor;
    }
}