class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int i =0;i<nums.length;i++){
            xor = xor ^ nums[i];
        }
        return minBitFlips(xor,k);
    }
    public int minBitFlips(int start, int goal) {
        int x = start^goal;
        int q = Integer.toBinaryString(x).length();
        int i = 0;
        int c = 0;
        for(int j =0;j<q;j++){
            if((1 << i & x) != 0) c++;
            i++;
        }
        return c;
    }
}