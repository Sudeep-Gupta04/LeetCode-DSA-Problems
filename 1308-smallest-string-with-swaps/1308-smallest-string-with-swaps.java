class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] arr = s.toCharArray();
        HashSet<String> hs = new HashSet<>();
        int n = s.length();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        for (List<Integer> i : pairs) {
            int u = i.get(0), v = i.get(1);
            String p1 = u + "," + v;
            String p2 = v + "," + u;
            if (hs.contains(p1) || hs.contains(p2)) continue;
            hs.add(p1);
            hs.add(p2);
            al.get(u).add(v);
            al.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ArrayList<Character> ch = new ArrayList<>();
                ArrayList<Integer> it = new ArrayList<>();
                dfs(vis, al, i, ch, it, s);
                Collections.sort(ch);
                Collections.sort(it);
                for (int j = 0; j < it.size(); j++) {
                    int idx = it.get(j);
                    arr[idx] = ch.get(j);
                }
            }
        }
        return new String(arr); // convert char[] to String
    }

    public void dfs(boolean[] vis, ArrayList<ArrayList<Integer>> al, int node,
                    ArrayList<Character> ch, ArrayList<Integer> it, String s) {
        vis[node] = true;
        ch.add(s.charAt(node));
        it.add(node);
        for (int i : al.get(node)) {
            if (!vis[i]) {
                dfs(vis, al, i, ch, it, s);
            }
        }
    }
}
