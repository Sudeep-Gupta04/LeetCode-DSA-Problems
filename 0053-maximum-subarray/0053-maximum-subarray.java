class Solution {
      public int maxSubArray(int[] nums) {
        int maximum=Integer.MIN_VALUE;
        int rs =0;
        for(int i =0;i<nums.length;i++){
            rs+=nums[i];
            if(rs>maximum) maximum = rs;
            
            if(rs<0) rs =0;
        }
        return maximum;
    }
}