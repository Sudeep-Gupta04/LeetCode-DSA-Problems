class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]>0){
                sum+=nums[i];
                max = Math.max(max,sum);
            }else{
                sum = nums[i];
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}