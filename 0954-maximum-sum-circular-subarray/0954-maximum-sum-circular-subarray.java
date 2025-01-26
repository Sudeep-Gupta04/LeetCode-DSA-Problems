class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        //int
        int fmax = Integer.MIN_VALUE;
        int sum = 0;
        int tsum = 0;
        for(int i =0;i<nums.length;i++){
            tsum+=nums[i];
            sum+=nums[i];
            fmax = Math.max(fmax,Math.max(sum,nums[i]));
            if(sum<0) sum =0;
        }
        int fmin=Integer.MAX_VALUE;
        sum=0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            fmin = Math.min(fmin,Math.min(sum,nums[i]));
            if(sum>0) sum =0;
        }
        if(tsum-fmin==0) return fmax;
        System.out.println(fmax+ " "+ fmin);
        return Math.max(fmax,tsum-fmin);
    }
}