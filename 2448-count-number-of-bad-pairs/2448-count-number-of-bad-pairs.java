class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer,Long> hm = new HashMap<>();
        //long tp = (nums.length-1)*(nums.length)/2;
        long p =0;
        for(int i =0;i<nums.length;i++){
            nums[i] = nums[i]-i;
            if(hm.containsKey(nums[i])){
                p -= hm.get(nums[i]);
            }
            hm.put(nums[i],hm.getOrDefault(nums[i], Long.valueOf(0))+1);
            p+=(nums.length-i-1);
        }
        //System.out.println(p+" "+tp);
        return  p;
    }
}