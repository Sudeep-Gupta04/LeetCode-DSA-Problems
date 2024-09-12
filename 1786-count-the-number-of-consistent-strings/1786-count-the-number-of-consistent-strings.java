class Solution {
     public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> hs = new HashSet<>();
        for(int i =0;i<allowed.length();i++){
            hs.add(allowed.charAt(i));
        }
        int ans =0;
        for(String str:words){
          ans+=check(str,hs);  
        }
        return ans;
    }

    private int check(String str, HashSet<Character> hs) {
        for(int i =0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!hs.contains(ch)) return 0;
        }
        return 1;
    }
}