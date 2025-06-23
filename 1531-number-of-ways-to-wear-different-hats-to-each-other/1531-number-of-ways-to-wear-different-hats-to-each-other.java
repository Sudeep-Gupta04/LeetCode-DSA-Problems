class Solution {
    HashMap<String,Integer> dp;
    int mod = (int)1e9+7;
    public int numberWays(List<List<Integer>> hats) {
        this.dp = new HashMap<>();
        int n = hats.size();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<=40;i++) al.add(new ArrayList<>());
        for(int i =0;i<n;i++){
            for(int j:hats.get(i)){
                al.get(j).add(i);
            }
        }

        return helper(1,al,n,0);
    }
    public int helper(int i,ArrayList<ArrayList<Integer>> al, int n,int mask){
        String key = i+","+mask;
        if(mask==((1<<n)-1)) return 1;
        if(i>=al.size()) return 0;
        
        if(dp.containsKey(key)) return dp.get(key);
        int ans =0;
        
        int take = 0; int ntake = 0;
        if(!al.get(i).isEmpty()){
            List<Integer> temp = al.get(i);
            for(int j =0;j<temp.size();j++){
                if((mask & (1<<temp.get(j)))==0){
                    ans = (ans + helper(i+1,al,n,(mask | (1<<temp.get(j)))))%mod;
                }
            }
            ans = (ans + helper(i+1,al,n,mask))%mod;
        }else{
            ans = (ans + helper(i+1,al,n,mask))%mod;
        }
        dp.put(key,ans);
        return ans;
    }
}