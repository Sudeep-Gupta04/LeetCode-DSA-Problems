class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[][] dis = new int[points.length][points.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        for(int i =0;i<points.length;i++){
            for(int j =0;j<(points.length);j++){
                dis[i][j] = Math.abs(points[j][1] - points[i][1]) + Math.abs(points[j][0] - points[i][0]);
                if(dis[i][j]==0) continue;
                int[] arr = {dis[i][j],i,j};
                pq.add(arr);
            }
        }
        for(int i =0;i<points.length;i++){
            System.out.println(Arrays.toString(dis[i]));
        }

        DSU dsu = new DSU(points.length);
        int ans = 0;
        while (!pq.isEmpty()){
            int[] arr = pq.remove();
            if(dsu.findParent(arr[1])!= dsu.findParent(arr[2])){
                System.out.println(Arrays.toString(arr));
                ans+=arr[0];
                dsu.union(arr[1],arr[2]);
            }
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
            int keyComparison = this.key.compareTo(other.key);
            return (keyComparison != 0) ? keyComparison : this.value.compareTo(other.value);
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
class DSU {
    int[] rank;
    int[] ultp;

    public DSU(int nodes) {
        rank = new int[nodes];
        ultp = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            ultp[i] = i;
        }
    }

    public int findParent(int node) {
        if (ultp[node] == node) {
            return node;
        }
        return ultp[node] = findParent(ultp[node]);
    }

    public void union(int n1, int n2) {
        int p1 = findParent(n1);
        int p2 = findParent(n2);

        if (p1 != p2) {
            int r1 = rank[p1];
            int r2 = rank[p2];

            if (r1 > r2) {
                ultp[p2] = p1;
            } else if (r1 < r2) {
                ultp[p1] = p2; 
            } else {
                ultp[p2] = p1; 
                rank[p1]++; 
            }
        }
    }
}