class Solution {
    Integer[] dp;
    public int minimumSubstringsInPartition(String s) {
        dp = new Integer[s.length()];
        return helper(0,s);
    }

    private int helper(int i, String s) {
        if(i>=s.length()) return 0;
        if(dp[i]!=null)  return dp[i];
        TreeMap<Integer,HashSet<Character>> tm = new TreeMap<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        int ans = 999999;
        for(int j = i;j<s.length();j++){
            char ch = s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            int freq = hm.get(ch);
            if(freq==1){
                if(tm.containsKey(freq)) tm.get(freq).add(ch);
                else tm.put(1,new HashSet<>(List.of(ch)));
            }else{
                tm.get(freq-1).remove(ch);
                if(tm.get(freq-1).isEmpty()) tm.remove(freq-1);
                tm.computeIfAbsent(freq, k -> new HashSet<>()).add(ch);
            }

            if(tm.size()==1){
                ans = Math.min(ans, 1+helper(j+1,s));
            }
        }
        return dp[i] = ans;
    }
}