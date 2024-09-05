class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int s = 0;
        int e = nums.length-1;
        int operations = 0;
        while(s<e){
            if(nums[s]+nums[e]==k){
                operations++;
                s++;
                e--;
            }
            else if(nums[s]+nums[e]<k) s++;
            else e--;
        }
        return operations;
    }
}