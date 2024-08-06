class Solution {
    public long largestPerimeter(int[] nums) {
         Arrays.sort(nums);
    long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for(int i =1;i<nums.length;i++){
            sum[i] = sum[i-1] + nums[i];
        }
        int i= nums.length-1;
        while(i!=1){
            if(sum[i-1]>nums[i]){
                return sum[i];
            }
            else {
                i--;
            }
        }
        return -1;
    }
} 