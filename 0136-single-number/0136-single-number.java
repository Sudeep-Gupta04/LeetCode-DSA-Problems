class Solution {
    public int singleNumber(int[] nums) {
         if(nums.length==1){
            return nums[0];
        }
           int element = nums[0]^nums[1];
       for(int i = 2;i<nums.length;i++){
           element = element^nums[i];
       }


        return element;
    }
 }
