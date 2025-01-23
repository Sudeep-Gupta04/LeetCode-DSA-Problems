import java.util.*;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) al.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != -1) al.get(i).add(edges[i]);
        }

        HashMap<Integer, Integer> nodeToIndexMap1 = new HashMap<>();
        HashMap<Integer, Integer> nodeToIndexMap2 = new HashMap<>();
        
        // Perform BFS from node2
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[edges.length];
        vis[node2] = true;
        q.add(node2);
        int index = 0;
        while (!q.isEmpty()) {
            int temp = q.remove();
            nodeToIndexMap2.put(temp, index++);
            for (int i : al.get(temp)) {
                if (!vis[i]) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }

        Arrays.fill(vis, false);
        vis[node1] = true;
        q.add(node1);
        index = 0;
        // Perform BFS from node1
        while (!q.isEmpty()) {
            int temp = q.remove();
            nodeToIndexMap1.put(temp, index++);
            for (int i : al.get(temp)) {
                if (!vis[i]) {
                    q.add(i);
                    vis[i] = true;
                }
            }
        }

        int[] arr = new int[edges.length];
        Arrays.fill(arr, Integer.MAX_VALUE);
        int pa = Integer.MIN_VALUE;
        
        // Check for common nodes and calculate the meeting distance
        for (Integer node : nodeToIndexMap1.keySet()) {
            if (nodeToIndexMap2.containsKey(node)) {
                int idx1 = nodeToIndexMap1.get(node);
                int idx2 = nodeToIndexMap2.get(node);
                pa = Math.max(idx1, idx2);
                arr[node] = pa;
            }
        }

        if (pa == Integer.MIN_VALUE) return -1;

        // Find the node with the minimum distance
        int temp = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < edges.length; i++) {
            if (arr[i] < temp) {
                temp = arr[i];
                ans = i;
            }
        }
        return ans;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
