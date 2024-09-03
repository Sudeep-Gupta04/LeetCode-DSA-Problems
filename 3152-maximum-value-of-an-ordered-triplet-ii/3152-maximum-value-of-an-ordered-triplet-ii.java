class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] pre = new int[nums.length];
        pre[0] = -1;
        int[] suf = new int[nums.length];
        suf[n-1] = -1;
        int max = nums[0];
        for(int i = 1;i<n;i++){
            pre[i] = max;
            if(nums[i]>max){
                max = nums[i];
            }
        }
        max = nums[n-1];
        for(int i =n-2;i>=0;i--){
            suf[i]=max;
            if(nums[i]>max) max = nums[i];
        }
        long ans = 0;
        for(int i =1;i< nums.length-1;i++){
            if((long) (pre[i] - nums[i]) *suf[i]>ans) ans = (long) (pre[i] - nums[i]) *suf[i];
        }
        return ans;
    }
}