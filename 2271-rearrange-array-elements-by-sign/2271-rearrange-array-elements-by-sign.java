class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int[] an = new int[nums.length/2];
        int[] ap = new int[nums.length/2];
        int j=0,k=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]<0){
                an[j] = nums[i];
                j++;
            }
            else {
                ap[k] = nums[i];
                k++;
            }
        }
       
        for(int i=0;i< nums.length/2;i++){
            ans[2*i]=ap[i];
            ans[2*i+1]=an[i];
        
        }
        return ans;
    }
}
