class Solution {
       public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i =0;i<n;i++) al.add(new ArrayList<>());
        int[] col = new int[n];
        Arrays.fill(col,-1);
        for(int i =0;i<dislikes.length;i++){
            al.get(dislikes[i][0]-1).add(dislikes[i][1]-1);
            al.get(dislikes[i][1]-1).add(dislikes[i][0]-1);
        }
        for(int i =0;i<col.length;i++){
            if(col[i]==-1){
                col[i]=0;
                if(dfs(i,col,al,1)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, int[]col, ArrayList<ArrayList<Integer>> al, int colour){
        boolean ans = false;
        for(int i:al.get(node)){
            if(col[i]==-1){
                col[i]=colour;
                ans = dfs(i,col,al,colour^1);
            }else if(col[i]==col[node]) {
                return true;
            }
        }
        return ans;
    }
}