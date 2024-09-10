class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int l = 0;
        int r = 0;
        long sum = 0;
        long ans = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        while(r<nums.length){
            if(!mp.containsKey(nums[r])){
                 mp.put(nums[r],r);
                sum+=nums[r];
            }
            else if(mp.containsKey(nums[r])){
                while(mp.containsKey(nums[r])){
                    sum = sum-nums[l];
                    mp.remove(nums[l]);
                    l++;
                }
            }
            if(mp.size()==k){
                ans =  Math.max(ans,sum);
                 mp.remove(nums[l]);
                sum = sum - nums[l];
                l++;
            }
            r++;
        }
    return ans;
    }
}