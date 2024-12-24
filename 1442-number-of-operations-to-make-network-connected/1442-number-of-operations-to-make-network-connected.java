class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; 

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            al.get(connection[0]).add(connection[1]);
            al.get(connection[1]).add(connection[0]);
        }

        boolean[] vis = new boolean[n];
        int components = 0;
        int redundantEdges = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                components++;
                redundantEdges += dfs(i, -1, al, vis);
            }
        }

        if (redundantEdges >= components - 1) {
            return components - 1;
        }
        return -1;
    }

    public int dfs(int node, int parent, ArrayList<ArrayList<Integer>> al, boolean[] vis) {
        vis[node] = true;
        int extraEdges = 0;

        for (int neighbor : al.get(node)) {
            if (!vis[neighbor]) {
                extraEdges += dfs(neighbor, node, al, vis);
            } else if (neighbor != parent) {
                extraEdges++; // Found a cycle (redundant edge)
            }
        }
        return extraEdges;
    }
}
