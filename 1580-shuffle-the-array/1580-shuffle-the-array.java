class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];

        for(int i = 0; i < n; i++){
            ans[i*2] = nums[i];
        }

        for(int j = 1; j < n+1; j++) {
            ans[(j*2)-1] = nums[n+j-1];
        }


    return ans;
    }
    
}