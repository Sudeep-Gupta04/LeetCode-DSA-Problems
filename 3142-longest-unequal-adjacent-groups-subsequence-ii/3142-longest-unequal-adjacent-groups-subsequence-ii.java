class Solution {
    HashMap<Integer, HashSet<String>> hm;

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            HashSet<String> hs = new HashSet<>();
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                char original = chars[j];
                chars[j] = 'X';
                hs.add(new String(chars));
                chars[j] = original;
            }
            hm.put(i, hs);
        }

        int[] path = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) path[i] = i;

        int max = 1, maxidx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isValid(i, j, words, groups) && dp[i] <= 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    path[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxidx = i;
            }
        }

        ArrayList<String> al = new ArrayList<>();
        int i = maxidx;
        while (path[i] != i) {
            al.add(words[i]);
            i = path[i];
        }
        al.add(words[i]);
        Collections.reverse(al);
        return al;
    }

    private boolean isValid(int i, int j, String[] words, int[] groups) {
        if (groups[i] == groups[j]) return false;

        HashSet<String> hs = hm.get(j);
        char[] chars = words[i].toCharArray();

        for (int k = 0; k < chars.length; k++) {
            char original = chars[k];
            chars[k] = 'X';
            if (hs.contains(new String(chars))) return true;
            chars[k] = original;
        }

        return false;
    }
}
