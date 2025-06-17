class Solution {
    Integer[] dp;
    int mod =(int)1e9+7;
    public int distinctSubseqII(String s) {
        int n = s.length();
        dp = new Integer[n];
        int[] res = new int[n];
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)){
                res[i] = -1;
            }else{
                res[i] = hm.get(ch);
            }
            hm.put(ch,i);
        }
        return helper(0,s,res);
    }
    public int helper(int i, String s, int[] nextidx){
        if(i==s.length()-1) return 1;
        if(dp[i]!=null) return dp[i];
        int set1 = 1 + helper(i+1,s,nextidx);
        int set2 = helper(i+1,s,nextidx);
        int commons1s2 = 0;
        if(nextidx[i]!=-1){
            if(nextidx[i]!= s.length()-1) commons1s2 = helper(nextidx[i]+1,s,nextidx);
            commons1s2 += 1;
        }
        return dp[i] = ((set1 + set2)%mod - commons1s2 + mod)%mod;
    }
}