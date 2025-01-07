class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans =new ArrayList<>();
        for(int i =0;i<words.length;i++){
            StringBuilder sb = new StringBuilder(words[i]);
            for(int j =0;j<words.length;j++){
                if(i==j) continue;
                else {
                    if(words[j].contains(sb)) {
                        ans.add(sb.toString());
                         break;
                    }
    
                }
            }
        }
        return ans;
    }
}