class Solution {
    HashMap<Integer,List<String>> dp;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = new HashMap<>();
        HashSet<String> hs = new HashSet<>();
        for(String i:wordDict) hs.add(i);
        List<String> pans = helper(0,s,hs);
        int k =0;
        for(String i:pans){
            pans.set(k++,i.substring(0,i.length()-1));
        }
        return pans;
    }

    private List<String> helper(int i, String s, HashSet<String> hs) {
        if(i>=s.length()) return new ArrayList<>(Arrays.asList(""));
        if(dp.containsKey(i)) return dp.get(i);
        List<String> tans = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        for(int k = i;k<s.length();k++){
            sb.append(s.charAt(k));
            if(hs.contains(sb.toString())){
                List<String> ls = helper(k+1,s,hs);
                if(!ls.isEmpty()){
                    for(String ans:ls) tans.add(sb+" "+ans);
                }
            }
        }
        dp.put(i,tans);
        return tans;
    }
}