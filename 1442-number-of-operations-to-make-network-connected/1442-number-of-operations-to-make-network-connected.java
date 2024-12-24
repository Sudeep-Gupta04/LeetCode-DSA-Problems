class Solution {
    int redundantEdges = 0;

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1; // Not enough edges to connect all nodes

        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        
        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }

        // Add connections to adjacency list
        for (int[] connection : connections) {
            al.get(connection[0]).add(connection[1]);
            al.get(connection[1]).add(connection[0]);
        }

        boolean[] vis = new boolean[n];
        int components = 0; // Count connected components
        
        // DFS to count components and redundant edges
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                components++;
                dfs(i, -1, al, vis);
            }
        }

        // If there are enough redundant edges to connect all components
        return redundantEdges >= components - 1 ? components - 1 : -1;
    }

    public void dfs(int node, int parent, ArrayList<ArrayList<Integer>> al, boolean[] vis) {
        vis[node] = true;

        for (int neighbor : al.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, node, al, vis);
            } else if (neighbor != parent) {
                // Only count the redundant edge if (node, neighbor) is the first encounter of the cycle
                redundantEdges++;
            }
        }
    }
}
