class Graph {
    ArrayList<ArrayList<int[]>> al;
    int[] dis;
    public Graph(int n, int[][] edges) {
        al = new ArrayList<>();
        dis = new int[101];
        for(int i =0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] i:edges){
            al.get(i[0]).add(new int[]{i[1],i[2]});
        }
    }

    public void addEdge(int[] edge) {
        al.get(edge[0]).add(new int[]{edge[1],edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        Arrays.fill(dis,(int)1e9);
        dis[node1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        pq.add(new int[]{0,node1});
        while(!pq.isEmpty()){
            int[] t = pq.remove();
            int node = t[1];
            int distance = t[0];
            if(node==node2) return distance;
            for(int[] i:al.get(node)){
                if(distance + i[1] < dis[i[0]]){
                    dis[i[0]] = distance + i[1];
                    pq.add(new int[]{dis[i[0]],i[0]});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */