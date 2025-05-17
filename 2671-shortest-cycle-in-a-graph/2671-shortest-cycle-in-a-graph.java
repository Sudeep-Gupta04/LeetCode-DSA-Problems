class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) al.add(new ArrayList<>());
        for (int[] i : edges) {
            al.get(i[0]).add(i[1]);
            al.get(i[1]).add(i[0]);
        }

        int pa = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int[] vis = new int[n];
            int[] par = new int[n];
            Arrays.fill(vis, -1);
            Arrays.fill(par, -1);

            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            vis[i] = 0;

            while (!q.isEmpty()) {
                int nod = q.remove();

                for (int neb : al.get(nod)) {
                    if (vis[neb] == -1) {
                        vis[neb] = vis[nod] + 1;
                        par[neb] = nod;
                        q.add(neb);
                    } else if (par[nod] != neb) {
                        pa = Math.min(pa, vis[nod] + vis[neb] + 1);
                    }
                }
            }
        }

        return (pa == Integer.MAX_VALUE) ? -1 : pa;
    }
}
