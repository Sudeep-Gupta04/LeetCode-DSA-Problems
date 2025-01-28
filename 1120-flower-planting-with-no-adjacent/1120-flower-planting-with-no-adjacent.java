class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
    int[] vis = new int[n + 1];
    Arrays.fill(vis, 0);
    
    ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    for (int i = 0; i <= n; i++) al.add(new ArrayList<>());
    
    for (int i = 0; i < paths.length; i++) {
        al.get(paths[i][0]).add(paths[i][1]);
        al.get(paths[i][1]).add(paths[i][0]);
    }
    
    for (int i = 1; i <= n; i++) {
        if (vis[i] == 0) dfs(i, al, vis);
    }
    
     return Arrays.copyOfRange(vis, 1, n + 1);
}


    private void dfs(int i, ArrayList<ArrayList<Integer>> al, int[] vis) {
        int[] col = new int[5];
        for(int neb: al.get(i)){
            if(vis[neb]!=0) col[vis[neb]]++;
        }
        int fill =0;
        for(int j=1;j<5;j++){
            if(col[j]==0){
                fill =j;
                break;
            }
        }
        vis[i] = fill;
        for(int neb: al.get(i)){
            if(vis[neb]==0) dfs(neb,al,vis);
        }
    }
}