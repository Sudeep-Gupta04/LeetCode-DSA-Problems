class Solution {
     public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] otd = new int[n];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i =0;i<n;i++) al.add(new ArrayList<>());

        for(int i =0;i<n;i++){
            for(int j =0;j<graph[i].length;j++){
                otd[i]++;
                al.get(i).add(graph[i][j]);
            }
        }
        HashSet<Integer> list = new HashSet<>();
        boolean[] vis = new boolean[n];
        for(int i =0;i<n;i++){
            if(!vis[i]){
                helper(i,al,list,vis);
            }
        }
       
        Integer[] array = list.toArray(new Integer[0]);
        Arrays.sort(array);
        return List.of(array);
    }
    public boolean helper(int n, ArrayList<ArrayList<Integer>> al,HashSet<Integer> ans,boolean[] vis){
        vis[n] = true;
        boolean possible = true;
        for(int i:al.get(n)){
            if(!vis[i] && ans.contains(i)) return true;
            else if(!vis[i]){
                possible = possible && helper(i,al,ans,vis);
            }
            else if(vis[i] && !ans.contains(i)) return false;
        }
        if(possible) ans.add(n);
        return possible;
    }
}