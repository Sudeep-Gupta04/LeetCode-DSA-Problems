class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();

        for (int stone : stones) {
            hm.put(stone, new HashSet<>());
        }
        if (hm.containsKey(stones[0] + 1)) {
            hm.get(stones[0] + 1).add(1);
        } else {
            return false;  
        }

        for (int i = 1; i < n; i++) {
            int cur = stones[i];
            for (int jump : hm.get(cur)) {
                if (jump - 1 > 0 && hm.containsKey(cur + jump - 1)) {
                    hm.get(cur + jump - 1).add(jump - 1);
                }
                if (hm.containsKey(cur + jump)) {
                    hm.get(cur + jump).add(jump);
                }
                if (hm.containsKey(cur + jump + 1)) {
                    hm.get(cur + jump + 1).add(jump + 1);
                }
            }
        }
        return !hm.get(stones[n - 1]).isEmpty();
    }
}
