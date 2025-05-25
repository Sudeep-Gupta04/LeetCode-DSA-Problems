class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int c =0;
        DSU red = new DSU(n+1);
        DSU green = new DSU(n+1);
        for(int[] i:edges){
            if(i[0]==3) {
                if(red.ultparent(i[1])!=red.ultparent(i[2])) {
                    red.union(i[1], i[2]);
                    green.union(i[1], i[2]);
                }else c++;
            }
        }
        for(int[] i:edges){
            if(i[0]==1){
                if(red.ultparent(i[1])!=red.ultparent(i[2])) red.union(i[1],i[2]);
                else{
                    c++;
                } 
            }else if (i[0]==2){
                if(green.ultparent(i[1])!=green.ultparent(i[2])) green.union(i[1],i[2]);
                else c++;
            }
            
        }
        for(int i=0;i<n+1;i++){
            if(i>1){
                if((red.ultparent(i)!=red.ultparent(i-1)) || (green.ultparent(i)!=green.ultparent(i-1)) ) return -1;
            }
        }
        return c;
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