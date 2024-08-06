class Solution {
    public int findMaxLength(int[] nums) {
       for(int i =0;i<nums.length;i++){
        if(nums[i]==0) nums[i]=-1;
       } 
       return  longestSubarrayWithSum(nums,0);
    }
     public static int longestSubarrayWithSum(int[] nums, int target) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;
        prefixSumMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (prefixSumMap.containsKey(currentSum - target)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(currentSum - target));
            }

            if (!prefixSumMap.containsKey(currentSum)) {
                prefixSumMap.put(currentSum, i);
            }
        }

        return maxLength;
    }
    
}