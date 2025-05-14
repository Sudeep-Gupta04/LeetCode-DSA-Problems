class Solution {
    public int longestCycle(int[] edges) {
        
        int n = edges.length;
       // if(n==8 && edges[0]==3 && edges[1]==3 && edges[2]==0 && edges[3]==0) return 2;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            if(edges[i] != -1) al.get(i).add(edges[i]);
        }

        boolean[] vis = new boolean[n];
        boolean[] pa = new boolean[n];
        int ans = -1;
        
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                int[] ter = {-1}; 
                int len = dfs(i, vis, al, ter, pa, new boolean[]{true});
                ans = Math.max(ans, len);
                //System.out.println(Arrays.toString(pa));
               // System.out.println(Arrays.toString(vis));
            }
        }
        return ans;
    }

    int dfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> al, int[] ter, boolean[] pa, boolean[] ps) {
        int c = -1;
        vis[src] = true;
        pa[src] = true;

        for(int i : al.get(src)) {
            if(vis[i]) {
                if(pa[i]) {
                    ter[0] = i;
                    pa[src] = false;
                    return 1;
                }
            } else {
                c = dfs(i, vis, al, ter, pa, ps);
                if(c > 0) {
                    if(ps[0] && i != ter[0]) {
                        pa[src] = false;
                        return c + 1;
                    } else if (i == ter[0]) {
                        ps[0] = false;
                        pa[src] = false;
                        return c;
                    }
                }
            }
        }

        pa[src] = false;
        return c;
    }
}