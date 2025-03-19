class Solution {
   public int findPairs(int[] nums, int k) {

        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(hs.contains(nums[i]) && k==0 && (hm.get(nums[i])<2)) ans++;
            if(!hs.contains(nums[i])){
                if(hm.containsKey(nums[i]+k) ) {
                    ans ++;
                }
                if(hm.containsKey(nums[i]-k)){
                    ans++;
                }
            }
            hs.add(nums[i]);
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(hm);
        return ans;
    }
}