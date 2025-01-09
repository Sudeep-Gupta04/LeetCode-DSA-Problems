class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1) return word;
        int ml = word.length() - numFriends + 1;
        int idx = 0;
        for(int i =1;i<word.length();i++){
            if(word.charAt(i) > word.charAt(idx)){
                idx = i;
            }
            else if(word.charAt(i) == word.charAt(idx) && (i!=word.length()-1)){
                int k = idx;
                int c =0;
                for(int j = i;j< Math.min(ml+i,word.length());j++,k++){
                    if(word.charAt(j)>word.charAt(k)){
                        c = 1;
                        break;
                    }if(word.charAt(j)<word.charAt(k)){
                        c = 2;
                        break;
                    }
                }
                if(c==1) idx = i;

            }
        }
        if(word.length() - idx > ml) return word.substring(idx,idx + ml);
        else{
           return word.substring(idx); 
        }
    }
}