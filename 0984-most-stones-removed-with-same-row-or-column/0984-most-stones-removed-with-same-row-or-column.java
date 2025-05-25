class Solution {
    public int removeStones(int [][] stones) {
        HashMap<Integer,Integer> row = new HashMap<>();
        HashMap<Integer,Integer> col = new HashMap<>();
        DSU dsu = new DSU(stones.length);
        int[] arr = dsu.par;
        for(int i =0;i<stones.length;i++){
            int x  = stones[i][0];
            int y = stones[i][1];
            if(!row.containsKey(x) && !col.containsKey(y)){
                row.put(x,i);
                col.put(y,i);
            }else if(row.containsKey(x) && col.containsKey(y)){
                int yidx = col.get(y);
                int xidx = row.get(x);
                dsu.union(yidx,i);
                dsu.union(xidx,i);
            }
            else{
                if(row.containsKey(x)){
                    int idx = row.get(x);
                    col.put(y,i);
                    dsu.union(idx,i);
                }else{
                    int idx = col.get(y);
                    row.put(x,i);
                    dsu.union(idx,i);
                }
            }
        }
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int i =0;i<arr.length;i++){
            int ele = dsu.ultparent(i);
            count.put(ele,count.getOrDefault(ele,0)+1);
        }
        int ans =0;
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            ans+= (entry.getValue()-1);
        }
        return ans;
    }
}
class DSU {
    int[] rank;
    int[] size;
    int[] par;

    DSU(int n) {
        rank = new int[n];
        size = new int[n];
        par = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            par[i] = i;
        }
    }

    public int ultparent(int node) {
        if (node == par[node]) return node;
        return par[node] = ultparent(par[node]);
    }

    public void union(int node1, int node2) {
        int ultparent1 = ultparent(node1);
        int ultparent2 = ultparent(node2);
        if (ultparent1 != ultparent2) {
            if (rank[ultparent1] > rank[ultparent2]) {
                size[ultparent1] += size[ultparent2];
                par[ultparent2] = ultparent1;
            } else if (rank[ultparent1] < rank[ultparent2]) {
                size[ultparent2] += size[ultparent1];
                par[ultparent1] = ultparent2;
            } else {
                rank[ultparent1]++;
                size[ultparent1] += size[ultparent2];
                par[ultparent2] = ultparent1;
            }
        }
    }
}