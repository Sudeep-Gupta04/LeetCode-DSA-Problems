class Solution {
    int c = 0;
    public int minReorder(int n, int[][] connections) {
        c = 0;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i=0;i<n;i++) al.add(new ArrayList<>());
        boolean[] vis = new boolean[n];
        HashSet<String> hm = new HashSet<>();
        for(int i =0;i<connections.length;i++){
            hm.add(connections[i][0]+" "+connections[i][1]);
            al.get(connections[i][1]).add(connections[i][0]);
            al.get(connections[i][0]).add(connections[i][1]);
        }
        //System.out.println(hm);
        //
        dfs(0,al,vis,hm);
        return c;
    }
    public void dfs(int src,  ArrayList<ArrayList<Integer>> al,boolean[] vis, HashSet<String>hm){
        vis[src] = true;
        for(int i:al.get(src)){
            if(!vis[i]){
               // System.out.println(src+" "+i);
                if(hm.contains(src+" "+i)) {
                    c++;
                    //System.out.println(src+" "+i);
                }
                dfs(i,al,vis,hm);
            }
        }
    }
}