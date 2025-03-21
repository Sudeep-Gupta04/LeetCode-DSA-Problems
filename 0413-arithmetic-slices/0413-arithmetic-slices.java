class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
       if(nums.length<3) return 0;
        int ans = 0;
        int l =0;int r =1;
        int d = nums[1] - nums[0];
        while(r<nums.length){
            if(nums[r]-nums[r-1]==d){
                d = nums[r]-nums[r-1];
                r++;
            }
            else{
                System.out.println(l+" "+r);
                if(r+1>= nums.length) {
                    break;
                }
                d = nums[r]-nums[r-1];
                int n = r-l-2;
                if(r-l>=3) ans += ((n*(n+1))/2);
                l = r-1;
            }
        }
        int n = r-l-2;
        ans += (n*(n+1))/2;
        return ans;
    }
}