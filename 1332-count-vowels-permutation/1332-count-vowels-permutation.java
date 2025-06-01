class Solution {
    int mod = (int)1e9+7;
    public int countVowelPermutation(int n) {
        HashMap<String,Integer> dp = new HashMap<>();
        HashMap<Character,List<Character>> hm = new HashMap<>();
        hm.put('z', Arrays.asList('a','e','i','o','u'));
        hm.put('a', Arrays.asList('e'));
        hm.put('e', Arrays.asList('a', 'i'));
        hm.put('i', Arrays.asList('a', 'e', 'o', 'u'));
        hm.put('o', Arrays.asList('i', 'u'));
        hm.put('u', Arrays.asList('a'));
        return helper(n,'z',dp,hm);
    }

    private int helper(int n, char pre, HashMap<String, Integer> dp,HashMap<Character,List<Character>> hm) {
        if(n==0) return 1;
        String key = n+","+pre;
        if(dp.containsKey(key)) return dp.get(key);
        int c =0;
        for(char ch:hm.get(pre)){
            c = (c + helper(n-1,ch,dp,hm))%mod;
        }
        dp.put(key,c%mod);
        return c%mod;
    }
}