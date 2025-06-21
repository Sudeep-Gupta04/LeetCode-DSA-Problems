class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();

    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        HashMap<Character, List<Integer>> hm = new HashMap<>();
        HashSet<Character> tar = new HashSet<>();

        for (int i = 0; i < n; i++) {
            char ch = target.charAt(i);
            tar.add(ch);
            if (hm.containsKey(ch)) hm.get(ch).add(i);
            else hm.put(ch, new ArrayList<>(Arrays.asList(i)));
        }

        int num = 0;
        HashMap<Integer, HashSet<Character>> common = new HashMap<>();
        for (int i = 0; i < stickers.length; i++) {
            HashSet<Character> chara = new HashSet<>();
            String word = stickers[i];
            for (char ch : word.toCharArray()) {
                if (tar.contains(ch)) chara.add(ch);
            }
            common.put(i, chara);
        }
        System.out.println(common);
        System.out.println(hm);
        int ans = helper(num, hm, common, target, stickers);
        return ans >= 9999999 ? -1 : ans;
    }

    public int helper(int mask, HashMap<Character, List<Integer>> hm, HashMap<Integer, HashSet<Character>> common, String target, String[] stker) {
        if (mask == (1 << target.length()) - 1) return 0;
        if (dp.containsKey(mask)) return dp.get(mask);

        int ans = 9999999;
        for (int i = 0; i < stker.length; i++) {
            HashSet<Character> com = common.get(i);
            if (!com.isEmpty()) {
                int newmask = mask;

                HashMap<Character, List<Integer>> newHM = new HashMap<>();
                for (Map.Entry<Character, List<Integer>> entry : hm.entrySet()) {
                    newHM.put(entry.getKey(), new ArrayList<>(entry.getValue()));
                }

                String word = stker[i];
                for (char ch : word.toCharArray()) {
                    if (newHM.containsKey(ch)) {
                        List<Integer> al = newHM.get(ch);
                        int idx = al.get(al.size() - 1);
                        newmask = newmask | (1 << idx);
                        al.remove(al.size() - 1);
                        if (al.isEmpty()) newHM.remove(ch);
                    }
                }

                if (newmask != mask) {
                    ans = Math.min(ans, 1 + helper(newmask, newHM, common, target, stker));
                }
            }
        }

        dp.put(mask, ans);
        return ans;
    }
}
