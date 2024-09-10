class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp = new HashMap<>();
        int l = 0;
        int r = 0;
        int c = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(mp.containsKey(ch)){
                while(mp.containsKey(ch)){
                    mp.remove(s.charAt(l));
                    l++;
                }
            }
            if(!mp.containsKey(ch)) {
                mp.put(ch, l);
                c = Math.max(c,mp.size());
            }
            r++;
        }
        return c;
    }
}