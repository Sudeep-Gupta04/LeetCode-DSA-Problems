class Solution {
public int isPrefixOfWord(String sentence, String searchWord) {
    int c = 1;
    for (int i = 0; i < sentence.length(); i++) {
        if (i==0) {
            if (sentence.startsWith(searchWord)) {
                return 1;
            }
        } 
        else {
            if (sentence.charAt(i) == ' ') {
                c++;
                String temp = sentence.substring(i + 1);
                if (temp.startsWith(searchWord)) {
                    return c;
                }
            }
        }
    }
    return -1;
}

}