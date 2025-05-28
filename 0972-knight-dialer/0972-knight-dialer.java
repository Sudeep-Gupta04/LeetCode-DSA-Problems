import java.util.*;

class Solution {
    public int knightDialer(int n) {
        int mod = (int) 1e9 + 7;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        hm.put(0, Arrays.asList(4, 6));
        hm.put(1, Arrays.asList(6, 8));
        hm.put(2, Arrays.asList(7, 9));
        hm.put(3, Arrays.asList(4, 8));
        hm.put(4, Arrays.asList(0, 3, 9));
        hm.put(5, new ArrayList<>());
        hm.put(6, Arrays.asList(0, 1, 7));
        hm.put(7, Arrays.asList(2, 6));
        hm.put(8, Arrays.asList(1, 3));
        hm.put(9, Arrays.asList(2, 4));
        HashMap<String, Integer> dp = new HashMap<>();
        int ans = 0;

        for (int i = 0; i <= 9; i++) {
            ans = (ans + helper(i, n - 1, dp, hm, mod)) % mod;
        }

        return ans;
    }

    private int helper(int num, int lv, HashMap<String, Integer> dp,
                       HashMap<Integer, List<Integer>> hm, int mod) {
        if (lv == 0) return 1;

        String key = num + "," + lv;
        if (dp.containsKey(key)) return dp.get(key);

        int ans = 0;
        for (int next : hm.get(num)) {
            ans = (ans + helper(next, lv - 1, dp, hm, mod)) % mod;
        }

        dp.put(key, ans);
        return ans;
    }
}
