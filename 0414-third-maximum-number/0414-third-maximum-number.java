class Solution {
    public int thirdMax(int[] nums) {
      Arrays.sort(nums);
      int num = nums[nums.length-1];
      int i =nums.length-2;
      int k = 2;
      while(i>=0 && k>0){
        if(nums[i]!=num){
            k--;
            num = nums[i];
        }
        i--;
    }
    if(i<=0 && k!=0) return nums[nums.length-1];
    return num;
    }
}