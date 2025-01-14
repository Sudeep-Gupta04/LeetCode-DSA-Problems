class Solution {
    public int getLargestOutlier(int[] nums) {
        HashMap<Double,Integer> hs = new HashMap<>();
        Arrays.sort(nums);
        int sum = 0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            hs.put((double) nums[i],i);
            sum+=nums[i];
        }
        for(int i =n-1;i>=0;i--){
            int wo = sum - nums[i];
            if(hs.containsKey(wo/2.0) && (hs.get(wo/2.0)!=i)) return nums[i];
        }
        return -1;
    }
}