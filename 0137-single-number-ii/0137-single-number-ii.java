class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i =0;i<32;i++){
            int num = 1;
            int c = 0;
            num = num << i;
            for(int j=0;j<nums.length;j++){
                if((nums[j] & num)!=0) c++;
            }
            if(c%3!=0) ans = (ans | num);
        }
        return ans;
    }
}