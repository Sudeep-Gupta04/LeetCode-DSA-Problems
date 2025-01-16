class Solution {
    
    public boolean isStretchy(String s, String word){
        int i = 0, j = 0;
        while(i < s.length() && j < word.length()){
            if(s.charAt(i) != word.charAt(j))
                return false;
            int x = i, y = j;
            while(x < s.length() && s.charAt(x) == s.charAt(i))
                x++;
            while(y < word.length() && word.charAt(y) == word.charAt(j))
                y++;
            if(y-j > x-i || (x-i > y-j && x-i < 3))
                return false;
            i = x;
            j = y;
        }
        return (i == s.length() && j == word.length());
    }
    
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for(String word : words){
            if(isStretchy(s, word))
                count++;
        }
        return count;
    }
}