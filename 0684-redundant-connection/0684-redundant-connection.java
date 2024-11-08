

class Solution {
    private int[] parent;
    private int[] rank;

    public int find(int i) {
        if (i == parent[i]) {
            return i;
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return;
        }

        if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else {
            parent[yParent] = xParent;
            rank[xParent]++;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int xParent = find(edge[0]);
            int yParent = find(edge[1]);

            if (xParent == yParent) {
                return edge;
            } else {
                union(edge[0], edge[1]);
            }
        }

        return new int[0];
    }
}
