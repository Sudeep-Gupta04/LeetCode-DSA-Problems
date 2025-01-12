class Solution {
    private Boolean[][] memo;

    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new Boolean[n][2 * n + 1];
       
        return helper(s, 0, 0);
    }

    public boolean helper(String s, int i, int balance) {
        if (balance < 0) {
            return false;
        }
        if (i == s.length()) {
            return balance == 0;
        }
        if (memo[i][balance + s.length()] != null) {
            return memo[i][balance + s.length()];
        }

        boolean ans;
        if (s.charAt(i) == '*') {
            ans = helper(s, i + 1, balance) // Treat '*' as empty
                    || helper(s, i + 1, balance + 1) // Treat '*' as '('
                    || helper(s, i + 1, balance - 1); // Treat '*' as ')'
        } else if (s.charAt(i) == '(') {
            ans = helper(s, i + 1, balance + 1);
        } else { // s.charAt(i) == ')'
            ans = helper(s, i + 1, balance - 1);
        }

        memo[i][balance + s.length()] = ans;
        return ans;
    }
}
