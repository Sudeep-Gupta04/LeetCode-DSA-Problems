class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] col = new int[graph.length];
        Arrays.fill(col,-1);
        for(int i =0;i<graph.length;i++){
            if(col[i] == -1 && fillColour(col,graph,0,i)) return false;
        }
        return true;
    }

    private boolean fillColour(int[] col, int[][] graph, int paint,int idx) {
        col[idx]=paint;
        boolean ans = false;
        for(int i:graph[idx]){
            if(col[i]==-1){
                if(paint == 1){
                    if(fillColour(col,graph,0,i)) return true;
                }
                else{
                    if(fillColour(col,graph,1,i)) return true;
                }
            }
            else {
                if(col[i]==paint){
                    return ans = true;
                }
            }
        }
        return ans;
    }
}