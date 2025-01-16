class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int num2zor = 0;
        if(nums1.length %2!=0){
            for(int i =0;i<nums2.length;i++){ num2zor = num2zor ^ nums2[i];}
        }
        int zornum2 =0;
        if(nums2.length %2!=0){
            for(int i =0;i<nums1.length;i++){ zornum2 = zornum2 ^ nums1[i];}
        }
        return zornum2 ^ num2zor;
    }
}