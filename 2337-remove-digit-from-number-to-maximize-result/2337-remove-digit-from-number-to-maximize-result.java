class Solution {
     public String removeDigit(String number, char digit) {
    int n = number.length();
    String ans = "";
    for (int i = 0; i < n; i++) {
        if (number.charAt(i) == digit) {
            String sub = number.substring(0, i) + number.substring(i + 1);
            if (ans.isEmpty() || sub.compareTo(ans) > 0) {
                ans = sub;
            }
        }
    }
    return ans;
}

}