class Solution {
    int mod =(int)1e9+7;int n;int m;
    HashMap<String,Integer> dp;
    public int numWays(String[] words, String target) {
        HashMap<Integer,HashMap<Character,Integer>> hs = new HashMap<>();
        dp = new HashMap<>();
        this.n = words.length;
        this.m = words[0].length();
        for(int j = 0;j<m;j++){
            HashMap<Character,Integer> temp = new HashMap<>();
            for(int i=0;i<n;i++){
                char ch = words[i].charAt(j);
                temp.put(ch,temp.getOrDefault(ch,0)+1);
            }
            hs.put(j,temp);
        }
        return helper(0,0,hs,target);
    }

    private int helper(int i, int j,HashMap<Integer,HashMap<Character,Integer>> hs , String tar) {
        if(j>=tar.length()) return 1;
        if(i>=m) return 0;
        String key = i+","+j;
        if(dp.containsKey(key)) return dp.get(key);
        int ans = 0;
        int frqAti = hs.get(i).getOrDefault(tar.charAt(j),0);
        if(frqAti>0){
            ans = (int)((ans + (1L*frqAti*helper(i+1,j+1,hs,tar)))%mod + helper(i+1,j,hs,tar))%mod;
        }
        else{
            ans = (ans + helper(i+1,j,hs,tar))%mod;
        }
        dp.put(key,ans);
        return ans;
    }
}