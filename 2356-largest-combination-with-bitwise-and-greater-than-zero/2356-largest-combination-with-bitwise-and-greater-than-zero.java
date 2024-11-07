class Solution {
        public int largestCombination(int[] candidates) {
        int[] arr = new int[24];
        for(int i =0;i<candidates.length;i++){
            int num = candidates[i];
            int bitc = Integer.toBinaryString(num).length();
            int c = 1;
            for(int j =0;j<bitc;j++){
                if((num & c)!=0){
                    arr[j]++;
                }
                c=c<<1;
            }
        }
        int ans = 0;
        for(int i =0;i<arr.length;i++){
            ans = Math.max(ans,arr[i]);
        }
        return ans;
    }
}