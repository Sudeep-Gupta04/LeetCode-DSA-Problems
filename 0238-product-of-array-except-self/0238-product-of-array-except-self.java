class Solution {
    public int[] productExceptSelf(int[] nums) {
            long product = 1;
            int pro =1;
            int count = 0;
            int idx = -1;
            for(int i =0;i<nums.length;i++){
                if(nums[i]==0){
                    count++;
                    idx = i;
                }
                if(nums[i]!=0) pro = pro * nums[i];
                product = product*nums[i];
            }
            int [] ans = new int[nums.length];
            if(count >= 2) return new int[nums.length];
            if(count==1){
                int[] brr = new int[nums.length];
                brr[idx] = pro;
                return brr;
            }
            for(int i =0;i< nums.length;i++){
                ans[i] = (int) (product/nums[i]);
            }
            return ans;
    }
}