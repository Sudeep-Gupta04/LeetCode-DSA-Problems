class Solution {
    public int maximumLength(String s) {
        int[] fre = new int[26];
        for(int i =0;i<s.length();i++){
            int idx = s.charAt(i)-97;
            fre[idx]+=1;
        }
        int l = 1;
        int h = s.length()-1;
        while(l<=h){
            int mid = (h+l)/2;
            if(isValid(s,mid,fre)) l = mid +1;
            else h = mid-1;
        }
        if(h==0){
           return -1;
        }
        return h;
    }

    private boolean isValid(String s, int size, int[] fre) {
        for (int i = 0; i < 26; i++) {
            if (fre[i] > 2) {  
                char ch = (char) (i + 97);
                int count = 0;
                int matchCount = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == ch) {
                        matchCount++;
                    } else {
                        matchCount = 0; 
                    }

                    if (matchCount >= size) {
                        count++;
                        if (count >= 3) return true;
                        matchCount--; 
                    }
                }
            }
        }
        return false;
    }
}