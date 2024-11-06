class Solution {
    public boolean canSortArray(int[] nums) {
        int difbitc = 0;
        int[] bitc = new int[nums.length+1];
        ArrayList<Integer> almax = new ArrayList<>();
        ArrayList<Integer> almin = new ArrayList<>();
        for(int i =0;i<nums.length;i++){
            bitc[i] = Integer.bitCount(nums[i]);
        }
        int intbit = bitc[0];
        int c=1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<bitc.length;i++){
            if(intbit!=bitc[i]){
                intbit = bitc[i];
                almin.add(min);
                almax.add(max);
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
            }
            if(i!=bitc.length-1){
                max = Math.max(max,nums[i]);
                min = Math.min(min,nums[i]);
            }
        }
        if(almax.size()==1)return true;
        for(int i =1;i< almax.size();i++){
            if(almin.get(i)<almax.get(i-1)) return false;
        }
        return true;
    }}