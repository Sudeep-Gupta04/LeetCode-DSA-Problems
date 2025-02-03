class Solution {
    public int longestMonotonicSubarray(int[] nums) {
       // if()
        // increasing
        int minc = 1;
        int s=0;
        int l=0;
        while(l<nums.length){
            int size = l-s+1;
            if(l==s) l++;
            else{
                if(nums[l]-nums[l-1]>0){
                    l++;
                    minc = Math.max(minc,l-s);
                }else {
                    minc = Math.max(minc,l-s);
                    s=l;
                }
            }
        }
        // decresing
        int mdec = 1;
        s=0;
        l=0;
        while(l<nums.length){
            int size = l-s+1;
            if(l==s) l++;
            else{
                if(nums[l-1]-nums[l]>0){
                    l++;
                    mdec = Math.max(mdec,l-s);
                }else {
                    mdec = Math.max(mdec,l-s);
                    s=l;
                }
            }
        }
        return Math.max(mdec,minc);
    }
}