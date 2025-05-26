class Solution {
    public int findLatestStep(int[] arr, int m) {
        HashSet<Integer> hs = new HashSet<>();
        int n = arr.length;
        DSU dsu = new DSU(n+1);
        int c = 0;
        int k = 1;
        int ans = -1;
        boolean check = false;
        for(int i:arr){
            int idx = i;
            hs.add(idx);
            dsu.size[idx]++;
            if(idx>0 && hs.contains(idx-1)){
                if(dsu.size[dsu.ultparent(idx-1)]==m) c--;
                dsu.union(idx,idx-1);
            }if(idx<n && hs.contains(idx+1)){
                if(dsu.size[dsu.ultparent(idx+1)]==m) c--;
                dsu.union(idx,idx+1);
            }
            int ultparent = dsu.ultparent(idx);
            int size = dsu.size[ultparent];
            
            if(size==m){
                c++;
            }
            if(c!=0) ans = k;
            k++;
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
          //  size[i] = 1;
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