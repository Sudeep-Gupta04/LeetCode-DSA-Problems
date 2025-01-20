class Solution {
     public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> al = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            int[] done = new int[26];
            String w = words[i];
            HashMap<Character,Character> hm = new HashMap<>();
            if(w.length()!=pattern.length()) continue;
            int c =0;
            for(int j =0;j<pattern.length();j++){
                if(!hm.containsKey(pattern.charAt(j)) && done[w.charAt(j)-97]==1){
                    c=1;
                    break;
                }
                else if(!hm.containsKey(pattern.charAt(j))){
                    hm.put(pattern.charAt(j),w.charAt(j));
                    done[w.charAt(j)-97]++;
                }else{
                    if(hm.get(pattern.charAt(j)) != w.charAt(j)){
                        c=1;
                        break;
                    }
                }
            }
            if(c==0) al.add(w);
        }
        return al;
    }
}