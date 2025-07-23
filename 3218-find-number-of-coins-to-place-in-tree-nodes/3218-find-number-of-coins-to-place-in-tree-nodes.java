class Solution {
    public long[] placedCoins(int[][] edges, int[] cost) {
        int n = cost.length;
        long[] ans = new long[n];
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i =0;i<n;i++) al.add(new ArrayList<>());
        for(int[] i:edges){
            al.get(i[0]).add(i[1]);
            al.get(i[1]).add(i[0]);
        }
        helper(al,ans,vis,0,cost);
        return ans;
    }

    private Pair helper(ArrayList<ArrayList<Integer>> al, long[] ans,boolean[] vis,int node,int[] cost) {
        vis[node] = true;
        PriorityQueue<Integer> min = new PriorityQueue<>();          // fro max 3element
        PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());  // fro min 3element
        min.add(cost[node]);max.add(cost[node]);
        for(int neb:al.get(node)){
            if(!vis[neb]){
               Pair p = helper(al,ans,vis,neb,cost);
               while(!p.minheap.isEmpty()){
                   min.add(p.minheap.remove());
                   if(min.size()>3) min.remove();
               }
                while(!p.maxheap.isEmpty()){
                    max.add(p.maxheap.remove());
                    if(max.size()>3) max.remove();
                }
            }
        }
        if(min.size()<3) ans[node] = 1;
        else{
            int minimum1 = max.remove();           // min3 min2 min1 max1 max2 max3
            int minimum2 = max.remove();
            int minimum3 = max.remove();

            int maximum1 = min.remove();
            int maximum2 = min.remove();
            int maximum3 = min.remove();

            long op1 = 1L*minimum3*minimum2*maximum3;
            long op2 = 1L*maximum1*maximum2*maximum3;
            ans[node] = Math.max(0,Math.max(op2,op1));
            min.add(maximum1);min.add(maximum2);min.add(maximum3);
            max.add(minimum1);max.add(minimum2);max.add(minimum3);
        }
       return new Pair(min,max);
    }
}
class Pair{
        PriorityQueue<Integer> minheap;PriorityQueue<Integer> maxheap;
        Pair(PriorityQueue<Integer> minheap,PriorityQueue<Integer> maxheap){
            this.minheap = minheap;
            this.maxheap = maxheap;
        }

    }