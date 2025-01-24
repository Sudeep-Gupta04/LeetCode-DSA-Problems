class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] distance = new double[n];
        Arrays.fill(distance,0.0);
        ArrayList<ArrayList<Pair>> al = new ArrayList<>();
        for(int i =0;i<n;i++) al.add(new ArrayList<Pair>());
        for(int i =0;i<edges.length;i++){
            al.get(edges[i][0]).add(new Pair<>(succProb[i],edges[i][1]));
            al.get(edges[i][1]).add(new Pair<>(succProb[i],edges[i][0]));
        }
        distance[start_node]=1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Pair(1.0,start_node));
        while(!pq.isEmpty()){
            Pair node = pq.remove();
            double dis = (double) node.key;
            int nd = (int) node.value;
            for(Pair p:al.get(nd)){
                if(dis*(double)p.key > distance[(int)p.value]) {
                    pq.add(new Pair(dis*(double)p.key,p.value));
                    distance[(int)p.value] = dis*(double)p.key;
                }
            }
        }
        return distance[end_node];
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
        int keyComparison = this.key.compareTo(other.key);
        return (keyComparison != 0) ? keyComparison : this.value.compareTo(other.value);
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}