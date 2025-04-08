class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int n = nums.length-1;
        int idx = n;
        for(int i = n;i>=0;i--){
            if(hs.contains(nums[i])){
                idx = i;
                break;
            }else hs.add(nums[i]);
        }
        //System.out.println(idx);
        if(idx==n) return 0;
        return (int)Math.ceil((idx+1)/3.0);
    }
}