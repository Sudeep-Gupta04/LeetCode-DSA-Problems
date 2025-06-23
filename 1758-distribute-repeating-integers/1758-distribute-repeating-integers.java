class Solution {
    HashMap<String, Boolean> dp;
    public boolean canDistribute(int[] nums, int[] quantity) {
        this.dp = new HashMap<>();
        Arrays.sort(nums);
        List<Integer> freq = new ArrayList<>();
        int c = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                freq.add(c);
                c=1;
            }else c++;
        }
        freq.add(c);

        return helper(0,freq,quantity,0);
    }

    private boolean helper(int i, List<Integer> freq,int[] quantity,int mask) {
        if(mask==(1<<quantity.length)-1) return true;
        if(i>=freq.size()) return false;

        String key = i+","+mask;

        if(dp.containsKey(key)) return dp.get(key);

        boolean ans = false;

        // for take get all the permutation of quatity;
        int take = 0;
        List<Integer> com = new ArrayList<>();
        List<Integer> ways = helper2(0,mask,quantity,freq.get(i),com);
        for(int tmask:ways){
            ans = ans | helper(i+1,freq,quantity,tmask);
            if(ans){
                dp.put(key,ans);
                return ans;
            }
        }
        ans = ans | helper(i+1,freq,quantity,mask);
        dp.put(key,ans);
        return ans;
    }

    public List<Integer> helper2(int i,int mask, int[] quantity,int tar,List<Integer> com){
        if(i>=quantity.length){
            com.add(mask);
            return com;
        } 
        //ntake
        helper2(i+1,mask,quantity,tar,com);

        // take
        if(((mask & (1<<i))==0) && (tar>=quantity[i])) helper2(i+1,(mask|(1<<i)),quantity,tar-quantity[i],com);
        return com;
    }
}