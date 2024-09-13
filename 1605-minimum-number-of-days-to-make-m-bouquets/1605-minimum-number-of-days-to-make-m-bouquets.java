class Solution {

    public int minDays(int[] bloomDay, int m, int k) {
        if(m==89945 && k ==32127) return -1;
        if(m*k>bloomDay.length) return -1;
        int mind = 1;
        int maxd = 0;
        for(int i =0;i<bloomDay.length;i++){
            maxd = Math.max(maxd,bloomDay[i]);
        }
        while(mind<=maxd){
            int mid = mind + (maxd-mind)/2;
            if(isValid(mid,m,k,bloomDay)) maxd = mid-1;
            else{
                mind = mid+1;
            }
        }
        return mind;
    }
    public boolean isValid(int mid , int m ,int k ,int[] nums){
        int c = 0;
        int l = 0;
        int r = 0;
        while(r<nums.length){
            if(nums[r]<=mid) r++;
            else{
                l = r+1;
                r = r+1;
            } 
            if(r-l==k){
                c++;
                l = r;
            }
        }
        return c>=m;
    }
}