import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        HashSet<Integer> safeNodes = new HashSet<>();
        HashSet<Integer> notAnswer = new HashSet<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, safeNodes, notAnswer, visited);
            }
        }

        // Convert the safe nodes to a sorted list
        Integer[] array = safeNodes.toArray(new Integer[0]);
        Arrays.sort(array);
        return List.of(array);
    }

    public boolean dfs(int node, int[][] graph, HashSet<Integer> safeNodes, HashSet<Integer> notAnswer, boolean[] visited) {
        if (notAnswer.contains(node)) return false; // Node is unsafe
        if (safeNodes.contains(node)) return true; // Node is already confirmed as safe

        visited[node] = true;
        boolean isSafe = true;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                isSafe = isSafe && dfs(neighbor, graph, safeNodes, notAnswer, visited);
            } else if (notAnswer.contains(neighbor) || !safeNodes.contains(neighbor)) {
                isSafe = false;
            }
        }

        if (isSafe) {
            safeNodes.add(node); // Mark the node as safe
        } else {
            notAnswer.add(node); // Mark the node as unsafe
        }
        return isSafe;
    }
}
