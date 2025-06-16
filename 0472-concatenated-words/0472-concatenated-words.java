class Solution {
   public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>(List.of(words));
        List<String> ans = new ArrayList<>();
        for (int i = 0;i<words.length;i++) {
             set.remove(words[i]);
             int[] dp = new int[words[i].length()];
             Arrays.fill(dp,-1);
             if(wordBreak(words[i],set,dp,0)) ans.add(words[i]);
             set.add(words[i]);
        }
        return ans;
    }
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
}