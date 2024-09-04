class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int p1 = (nums[n-1]*nums[n-2]*nums[n-3]);
        if(nums[0]>=0) return p1;
        else if(nums[0]*nums[1]>=0){
            if(nums[n-1]>=0) return Math.max(nums[0]*nums[1]*nums[n-1],p1) ;
            else return p1;
        } 
        else if(nums[2]>0) return p1;
        return p1;
    }
}