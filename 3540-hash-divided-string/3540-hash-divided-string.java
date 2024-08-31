class Solution {
    public String stringHash(String s, int k) {
    int q = k;
    StringBuilder ans = new StringBuilder();
    int ascii = 0;

    for (int i = 0; i < s.length(); i++) {
        
        ascii += (s.charAt(i) - 97);
        k--;
        if (k == 0) {
            ascii = ascii % 26;
            ans.append((char) (ascii + 97));
            k = q;
            ascii = 0;
            continue;  // Reset ascii for the next segment
        }
    }
   return ans.toString();
}

}