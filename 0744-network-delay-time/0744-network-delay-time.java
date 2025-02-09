public class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] time : times) {
            graph.get(time[0]).add(new Pair<>(time[2], time[1]));
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>();
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[k] = 0;
        pq.add(new Pair<>(0, k));

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> p = pq.poll();

            for (Pair<Integer, Integer> i : graph.get(p.value)) {
                if (dis[i.value] > dis[p.value] + i.key) {
                    dis[i.value] = dis[p.value] + i.key;
                    pq.add(new Pair<>(dis[i.value], i.value));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dis[i]);
        }

        return ans;
    }
}

class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Pair<K, V>> {
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair<K, V> other) {
        return this.key.compareTo(other.key);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
