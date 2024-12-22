class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++){
            max[i] = nums[i]+k;
            min[i] = nums[i]-k;
        }
        int l = 0;int r =0;
        int ans = 0;
        while(r<nums.length){
            int size = r - l + 1;
            if(max[l]>=min[r]){
                ans = Math.max(ans,size);
                r++;
            } 
            else{
                r++;
                l++;
            } 
        }
        return ans;
    }
}