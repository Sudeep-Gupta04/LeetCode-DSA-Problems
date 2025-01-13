class Solution {
   public int[] singleNumber(int[] nums) {
        int num1 = 0;
        int num0 = 0;
        int xor = 0;
        for(int i =0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        int bit = (((xor - 1) & xor) ^ xor);

        for(int i =0;i<nums.length;i++){
            if((bit & nums[i])!=0){
                num1 = (num1 ^ nums[i]);
            }
            else{
                num0 = num0 ^ nums[i];
            }
        }
        return new int[]{num1,num0};
    }
}