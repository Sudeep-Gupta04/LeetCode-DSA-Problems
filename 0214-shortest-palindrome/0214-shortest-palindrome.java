class Solution {
    public String shortestPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) return s;
        int sub = s.length();
        while (sub > 1) {
            int left = 0;
            int right = sub - 1;
            boolean isPalindrome = true;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    isPalindrome = false;
                    break;
                }
                left++;
                right--;
            }
            if (isPalindrome) {
                String remaining = s.substring(sub);
                return new StringBuilder(remaining).reverse().toString() + s;
            }
            sub--;
        }
        return new StringBuilder(s.substring(1)).reverse().toString() + s;
    }
}
