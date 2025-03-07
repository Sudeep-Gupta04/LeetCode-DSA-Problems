class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i =0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i] = 2 * nums[i];
                nums[i+1]=0;
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        int[] ans = new int[nums.length];
        int k =0;
        for(int i =0;i<nums.length && k<nums.length;i++){
            if(nums[k]!=0){
                ans[i]=nums[k++];
            }else{
                i--;
                k++;
            }
        }
        return ans;
    }
}