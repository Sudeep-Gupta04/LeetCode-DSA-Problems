class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return new ArrayList<>(Arrays.asList(0));
        if (n == 2) return new ArrayList<>(Arrays.asList(0, 1));
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        int[] inoder = new int[n];

        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
            hs.add(i);
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            al.get(u).add(v);
            al.get(v).add(u);
            inoder[u]++;
            inoder[v]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inoder[i] == 1) {
                q.add(i);
                hs.remove(i);
            }
        }
        while (!hs.isEmpty()) {
            int size = q.size();
            if (hs.size() <= 2) break;
            for (int i = 0; i < size; i++) {
                int nod = q.remove();
                for (int neighbor : al.get(nod)) {
                    inoder[neighbor]--;
                    if (inoder[neighbor] == 1) {
                        q.add(neighbor);
                        hs.remove(neighbor);
                    }
                }
            }
        }
        return new ArrayList<>(hs);
    }
}
