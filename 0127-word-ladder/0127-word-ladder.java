class Solution {
     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        HashMap<String,List<String>> words = new HashMap<>();
        if(!wordList.contains(beginWord)) wordList.add(beginWord);
        for(int i =0;i<wordList.size();i++){
            String w1 = wordList.get(i);
            for(int j =0;j<wordList.size();j++){
                String w2 = wordList.get(j);
                int c =0;
                if(w2.length()!=w1.length()) continue;
                for(int k =0;k<w1.length();k++){
                    if(w1.charAt(k)!=w2.charAt(k)) c++;
                }
                if (c == 1) {
                    List<String> temp;
                    if(!words.containsKey(w1)){
                        temp = new ArrayList<>();
                        temp.add(w2);
                    }else{
                        temp = words.get(w1);
                        temp.add(w2);
                    }
                    words.put(w1,temp);
                }
            }
        }
        int c = 0;
        HashSet<String> hs = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        hs.add(beginWord);q.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i =0;i<size;i++){
                String st = q.remove();
                if(st.equals(endWord)) return c+1;
                if(words.containsKey(st)){
                    List<String> ql = words.get(st);
                    for(String s:ql){
                        if(!hs.contains(s)){
                            q.add(s);
                            hs.add(s);
                        }
                    }
                }
            }
            c++;
        }
        return 0;
    }
}