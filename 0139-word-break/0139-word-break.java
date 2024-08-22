
    class Solution {
    private boolean wordBreak(String s, Set<String> set, int[] memo, int start) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != -1) {
            return memo[start] == 1;
        }
        for (int i = start; i < s.length(); i++) {
            if (set.contains(s.substring(start, i + 1)) && wordBreak(s, set, memo, i + 1)) {
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = 0;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int[] memo = new int[s.length()];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;  // Initialize memo array with -1
        }
        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(s, set, memo, 0);
    }

}