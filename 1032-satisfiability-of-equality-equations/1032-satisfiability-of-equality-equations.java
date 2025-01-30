class Solution {
     public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(30);
        int n = equations.length;
        for(int i =0;i<n;i++){
            String st = equations[i];
            if(st.charAt(1)=='='){
                 dsu.union(st.charAt(0)-97,st.charAt(3)-97);
            }
        }
        for(int i =0;i<n;i++){
            String st = equations[i];
            if(st.charAt(1)!='='){
                 if(dsu.findParent(st.charAt(0)-97) == dsu.findParent(st.charAt(3)-97)) return false;
            }
        }
        
        return true;
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