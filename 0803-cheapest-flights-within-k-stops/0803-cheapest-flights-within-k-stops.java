import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) al.add(new ArrayList<pair>());
        for (int i = 0; i < flights.length; i++) {
            al.get(flights[i][0]).add(new pair(flights[i][1], flights[i][2]));
        }
    
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        Queue<triplet> pq = new ArrayDeque<>();
        pq.add(new triplet(0, 0, src)); // {stops, cost, node}

        while (!pq.isEmpty()) {
            triplet t = pq.remove();
            int stops = t.k;
            int node = t.node;
            int cost = t.w;
            if (stops > k) continue;
            for (pair p : al.get(node)) {
                int neighbor = p.x;
                int edgeWeight = p.w;
                if (cost + edgeWeight < dis[neighbor]) {
                    dis[neighbor] = cost + edgeWeight;
                    pq.add(new triplet(stops + 1, cost + edgeWeight, neighbor));
                }
            }
        }
        return (dis[dst]==Integer.MAX_VALUE) ? -1 : dis[dst];
    }
}

// Custom triplet class to store {stops, cost, node}
class triplet implements Comparable<triplet> {
    int k; // number of stops
    int w; // cost (weight)
    int node; // current node

    triplet(int k, int w, int node) {
        this.k = k;
        this.w = w;
        this.node = node;
    }

    @Override
    public int compareTo(triplet other) {
        return Integer.compare(this.k, other.k); // Min-Heap based on 'w' (cost)
    }
}

// Custom pair class to store {node, edge weight}
class pair implements Comparable<pair> {
    int x; // destination node
    int w; // weight (cost)

    pair(int x, int y) {
        this.x = x;
        this.w = y;
    }

    @Override
    public int compareTo(pair other) {
        return Integer.compare(this.w, other.w); // Min-Heap based on 'w' (cost)
    }
}
