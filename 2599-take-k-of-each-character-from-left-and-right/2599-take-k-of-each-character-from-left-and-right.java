class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        if (s.length() < 3) return -1;

        int a = 0, b = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') a++;
            else if (s.charAt(i) == 'b') b++;
            else c++;
        }
        if (Math.min(Math.min(a, b), c) < k) return -1;

        int l = 0, r = 0, size = 0;
        while (r < s.length()) {
            if (s.charAt(r) == 'a') {
                a--;
                if (a < k) {
                    while (a < k && l <= r) {
                        if (s.charAt(l) == 'a') a++;
                        else if (s.charAt(l) == 'b') b++;
                        else c++;
                        l++;
                    }
                }
            } else if (s.charAt(r) == 'b') {
                b--;
                if (b < k) {
                    while (b < k && l <= r) {
                        if (s.charAt(l) == 'a') a++;
                        else if (s.charAt(l) == 'b') b++;
                        else c++;
                        l++;
                    }
                }
            } else { 
                c--;
                if (c < k) {
                    while (c < k && l <= r) {
                        if (s.charAt(l) == 'a') a++;
                        else if (s.charAt(l) == 'b') b++;
                        else c++;
                        l++;
                    }
                }
            }
            size = Math.max(size, r - l + 1);
            r++;
        }

        // Minimum characters to remove
        return s.length() - size;
    }
}
