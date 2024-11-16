class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int size = nums.length - k+1;
        int[] ans = new int[size];
        int l = 0;
        int r = 0;
        int power = nums[0];
        int f =0;
        int idx = 0;
      
        for(int i = 1;i<k;i++,r++){
            if((nums[i]==1+nums[i-1]) && (f!=1)){
                power = nums[i];
            }else{
                if(nums[i]!=1+nums[i-1]){
                    idx = i-1;
                }
                f=1;
                power = -1;
            }
        }
        k = 0;
        ans[k++]=power;
        l++;  r++;
        while(r<nums.length){
            if(nums[r]!=nums[r-1]+1){
                idx = r-1;
            }
            if(l<=idx) ans[k++]=-1;
            else{
                ans[k++] = nums[r];
            }
            l++;r++;
        }
      return ans;
    }
}