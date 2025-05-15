class Solution {
        public int[] countOfPairs(int n, int x, int y) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i =0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int i =0;i<n-1;i++){
            al.get(i).add(i+1);
            al.get(i+1).add(i);
        }
        al.get(x-1).add(y-1);
        al.get(y-1).add(x-1);
        int[] ans = new int[n];
        boolean[] vis = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();
        for(int i =0;i<n;i++){
            int c = 0;
            vis[i] = true;
            q.add(i);
            while(!q.isEmpty()){
                int size = q.size();
                if(c!=0) ans[c-1] += size;
                for(int j =0;j<size;j++){
                    int node = q.remove();
                    for(int nds:al.get(node)){
                        if(!vis[nds]){
                            vis[nds] = true;
                            q.add(nds);
                        }
                    }
                }
                c++;
            }
            Arrays.fill(vis,false);
        }
        return ans;
    }
}