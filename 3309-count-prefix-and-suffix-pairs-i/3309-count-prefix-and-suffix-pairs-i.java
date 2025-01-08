class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        for(int j =0;j<words.length;j++){
            for(int i =0;i<j;i++){
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i])) ans++;
            }
        }
        return ans;
    }
}