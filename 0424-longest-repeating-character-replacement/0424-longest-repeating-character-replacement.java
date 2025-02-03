class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        for (int i = 65; i <= 90; i++) {
            char ch = (char) i;
            int st = 0, e = 0, tk = k, max = 0;
            
            while (e < s.length()) {
                if (s.charAt(e) == ch) {
                    e++;
                } else {
                    if (tk > 0) {
                        e++;
                        tk--;
                    } else {
                        if (s.charAt(st) != ch) {
                            tk++;
                        }
                        st++;
                    }
                }
                max = Math.max(max, e - st);
            }
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
