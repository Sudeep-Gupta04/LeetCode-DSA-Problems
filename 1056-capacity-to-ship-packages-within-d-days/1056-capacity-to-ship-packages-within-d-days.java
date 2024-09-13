class Solution {
   public int shipWithinDays(int[] weights, int days) {
        int mincap = 0;
        int maxcap = 0;
        for(int i =0;i<weights.length;i++){
            maxcap += weights[i];
            mincap = Math.max(mincap,weights[i]);
        }
        while(mincap<=maxcap){
            int mid = (mincap+maxcap)/2;
            if(isValid(mid,weights,days)) maxcap = mid-1;
            else{
                mincap = mid +1;
            }
        }
        return mincap;
    }
    public boolean isValid(int mid, int[] nums, int days){
        int cap = mid;
        int d = 1;
        for(int i =0;i<nums.length;i++){
            if(cap>=nums[i]) cap -= nums[i];
            else{
                cap = mid;
                d = d+1;
                cap -= nums[i];
            }
            if(d>days) return false;
        }
        return d<=days;
    }
}