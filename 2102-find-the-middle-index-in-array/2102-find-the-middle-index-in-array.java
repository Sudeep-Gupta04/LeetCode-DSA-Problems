class Solution {
    public int findMiddleIndex(int[] nums) {
        int s = 0;
        for(int i =0;i<nums.length;i++) s+=nums[i];
        int ls = 0;
        if(s-nums[0]==0) return 0;
        for(int i =1;i<nums.length;i++){
            ls+=nums[i-1];
            if(ls==s-ls-nums[i]) return i;
        }
        return -1;
    }
}