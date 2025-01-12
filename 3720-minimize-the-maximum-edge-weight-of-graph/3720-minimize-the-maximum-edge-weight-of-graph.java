class Solution {
    int c = 0;
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        ArrayList<ArrayList<Pair>> al = new ArrayList<>();
        for(int i =0;i<n;i++) al.add(new ArrayList<>());
        for(int i =0;i<edges.length;i++){
            al.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        int s = 0; int e = (int) 1e6;
        while(s<=e){
            c=0;
            int mid = (s+e)/2;
            if(isValid(al,mid,n)) e = mid -1;
            else s = mid+1;
        }
        return e==1000000?-1:e+1;
    }

    public boolean isValid(ArrayList<ArrayList<Pair>> al,int mid,int n){
        boolean[] vis = new boolean[n];
        dfs(0,vis,al,mid);
        return c==n;
    }
    public void dfs(int s,boolean[] vis,ArrayList<ArrayList<Pair>> al,int mid){
        c++;
        vis[s] = true;
        for(Pair p:al.get(s)){
            if(!vis[p.node]){
                if(p.w<=mid) dfs(p.node,vis,al,mid);
            }
        }
    }
}
class Pair{
    int node;
    int w;

    Pair(int node, int w){
        this.node = node;
        this.w = w;
    }
}