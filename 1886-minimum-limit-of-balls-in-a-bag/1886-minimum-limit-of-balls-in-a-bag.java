class Solution {
   public int minimumSize(int[] nums, int maxOperations) {
        int l = 100000;int h =0;
        for(int i =0;i<nums.length;i++){
            l = Math.min(l,nums[i]);
            h = Math.max(h,nums[i]);
        }
        l = 1;
        while(l<=h){
            int mid = (l+h)/2;
            if(isValid(mid,nums,maxOperations)) h = mid -1;
            else l = mid + 1;
        }
        return l;
    }

      static private boolean isValid(int mid, int[] nums, int ope) {
       
        int i =0;
        int c =0;
        while(i<nums.length){
            if(nums[i]<= mid) {
                i++;
                continue;
            } else {
                if(nums[i]%mid==0){
                    if((c+(nums[i] /mid) -1) >ope) break;
                    else c+= (nums[i] / mid) -1 ; 
                }else{
                    if((c+(nums[i] /mid)) >ope) break;
                    else c+= (nums[i] / mid) ; 
                }
                i++;
            }
        }
        if(i!=nums.length) return false;
        else return true;
    }
}