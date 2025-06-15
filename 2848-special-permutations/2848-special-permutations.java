class Solution {
    int mod = (int)1e9+7;
    HashMap<String,Integer> hm = new HashMap<>();
    public int specialPerm(int[] nums) {
        int bit = 0;
        return helper(bit,-1,0,nums);
    }

    public int helper(int bit, int prvidx, int i,int[] nums){
        if(i==nums.length) return 1;
        String key = prvidx+" "+bit;
        if(hm.containsKey(key)) return hm.get(key);
        int ans = 0;
        for(int p = 0;p<nums.length;p++){
            if(prvidx==-1){
                ans = (ans + helper(bit|(1<<p),p,i+1,nums))%mod;
            }else{
                int prvnum = nums[prvidx];
                if((bit & (1<<p))==0 &&  (prvnum%nums[p]==0 || nums[p]%prvnum==0)){
                    ans = (ans + helper(bit|(1<<p),p,i+1,nums))%mod;
                }
            }
        }
        hm.put(key,ans);
        return ans;
    }
}