class Solution {
    HashMap<String, List<Integer>> dp;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        this.dp = new HashMap<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int n = req_skills.length;

        for (int i = 0; i < n; i++) {
            hm.put(req_skills[i], i);
        }

        List<Integer> selected = helper(0, hm, 0, people, n);
        if (selected == null) return new int[0];

        int[] ans = new int[selected.size()];
        for (int i = 0; i < selected.size(); i++) {
            ans[i] = selected.get(i);
        }
        return ans;
    }

    public List<Integer> helper(int i, HashMap<String, Integer> hm, int mask, List<List<String>> al, int n) {
        if (mask == (1 << n) - 1) return new ArrayList<>();
        if (i >= al.size()) return null;

        String key = i + "," + mask;
        if (dp.containsKey(key)) return dp.get(key);

        List<Integer> take = null, notake;

        int newmask = mask;
        for (String str : al.get(i)) {
            if (hm.containsKey(str)) {
                newmask |= 1 << hm.get(str);
            }
        }

        if (newmask != mask) {
            take = helper(i + 1, hm, newmask, al, n);
            if (take != null) {
                take = new ArrayList<>(take);
                take.add(i);
            }
        }

        notake = helper(i + 1, hm, mask, al, n);

        List<Integer> result;
        if (take == null && notake == null) result = null;
        else if (take == null) result = notake;
        else if (notake == null) result = take;
        else result = (take.size() < notake.size()) ? take : notake;

        dp.put(key, result);
        return result;
    }
}
