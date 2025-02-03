class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i =0;i<s.length();i++){
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i =0;i<t.length();i++){
            char ch = t.charAt(i);
            if(mp.containsKey(ch)){
                int size = mp.remove(ch);
                if(size>1){
                    mp.put(ch,size-1);
                }
            }else{
                return false;
            }
        }
        return (mp.size()==0);
    }
}