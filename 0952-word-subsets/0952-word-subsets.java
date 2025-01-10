class Solution {
     public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i =0;i<words2.length;i++){
            String temp = words2[i];
            HashMap<Character,Integer> tmap = new HashMap<>();
            for(int j =0;j<temp.length();j++){
                tmap.put(temp.charAt(j), tmap.getOrDefault(temp.charAt(j), 0) + 1);
            }
            for(Map.Entry<Character,Integer> k: tmap.entrySet()){
                char ch = k.getKey();
                int val = k.getValue();
                if(hm.containsKey(ch)){
                    if(hm.get(ch)<val){
                        hm.put(ch,val);
                    }
                }else{
                    hm.put(ch,val);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i =0;i<words1.length;i++){
            String temp = words1[i];
            HashMap<Character,Integer> tmap = new HashMap<>();
            for(int j =0;j<temp.length();j++){
                tmap.put(temp.charAt(j), tmap.getOrDefault(temp.charAt(j), 0) + 1);
            }
            int c =0;
            for(Map.Entry<Character,Integer> k: hm.entrySet()){
                char ch = k.getKey();
                int val = k.getValue();
                if(tmap.containsKey(ch)){
                    if(tmap.get(ch) < val){
                        c=1;
                        break;
                    }
                }else{
                    c=1;
                    break;
                }
            }
            if(c==0) ans.add(temp);
        }
        return ans;
    }
}