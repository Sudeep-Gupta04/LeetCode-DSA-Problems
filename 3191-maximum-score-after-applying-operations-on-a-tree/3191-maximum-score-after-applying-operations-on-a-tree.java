class Solution {
    HashMap<Integer,Long> pre = new HashMap<>();
    ArrayList<ArrayList<Integer>> al;
    boolean[] vis;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        this.vis = new boolean[n];
        this.al = new ArrayList<>();
        for(int i =0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] i:edges){
            int par = i[0]; int child = i[1];
            al.get(par).add(child);
            al.get(child).add(par);
        }
        prefixsum(0,values);
        this.vis = new boolean[n];
        System.out.println(pre);
        return helper(0,values);
    }
    public long helper(int node,int[] values){
        vis[node] = true;
        long p1 = pre.get(node) - values[node]; // take everthing leave the root
        long p2 = values[node];
        int flag = 0;
        for(int child:al.get(node)){
            if(!vis[child]){
                flag =1;
                p2 += helper(child,values);
            }
        }
        if(flag ==0) p2 =0;
        return Math.max(p1,p2);
    }

    public long prefixsum(int node, int[] values){
        vis[node] = true;
        long sum = values[node];
        for(int child:al.get(node)){
            if(!vis[child]){
                sum += prefixsum(child,values);
            }
        }
        pre.put(node,sum);
        return sum;
    }
}