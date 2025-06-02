class Solution {
    int mod = (int)1e9+7;
    HashMap<String,Integer> hm;
    int len;
    public int numOfWays(int n) {
        len = n * 3;
        hm = new HashMap<>();
        return helper(0,"");
    }
    public int helper(int n,String pre){
        if(n>=len) return 1;
        String key = n+","+pre;
        if(hm.containsKey(key)) return hm.get(key);
        int ans = 0;
        if(pre.equals("")){
            ans = (ans + helper(n+1,"1") + helper(n+1,"2") + helper(n+1,"3"))%mod;
        }else{
            for(int i =1;i<=3;i++){
                // check prev for all other than the end
                if(pre.length()<3 && !pre.endsWith(i+"")){
                    ans = (ans + helper(n+1,pre+i))%mod;
                }
                else{
                    if(n%3!=0 && !pre.endsWith(i+"") && !pre.startsWith(i+"")){
                        ans = (ans + helper(n+1,pre.substring(1)+i))%mod;
                    }
                    else if(n%3==0 && !pre.startsWith(i+"")){
                        ans = (ans + helper(n+1,pre.substring(1)+i))%mod;
                    }
                }
            }
        }
        hm.put(key,ans%mod);
        return hm.get(key);
    }
}