class Solution {
    HashMap<String,Integer> hm;
    int mod = (int)1e9+7;
    public int sumOfPowers(int[] nums, int k) {
        hm = new HashMap<>();
        Arrays.sort(nums);
        return helper(0,-1,k,Integer.MAX_VALUE,nums);
    }
    public int helper(int i, int prv,int k,int min, int[] nums){
        String key = prv+","+k+","+min;
        if(k==0) return min % mod;
        if(i>=nums.length) return 0;
        if(hm.containsKey(key)) return hm.get(key);
        int take;
        if(prv==-1){
            take = helper(i+1,i,k-1,min,nums);
        }else{
            take = helper(i+1,i,k-1,Math.min(min,Math.abs(nums[i]-nums[prv])),nums);
        }
        int ntake = helper(i+1,prv,k,min,nums);
        hm.put(key,((ntake + take)%mod));
        return ((ntake + take)%mod);
    }
}