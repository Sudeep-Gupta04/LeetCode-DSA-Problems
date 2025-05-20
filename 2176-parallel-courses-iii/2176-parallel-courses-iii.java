class Solution {
     public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        int[] start = new int[n];
        Arrays.fill(start,-1);
        for(int i =0;i<n;i++){
            al.add(new ArrayList<>());
        }
        int[] ind = new int[n];
        for(int[]i:relations){
            al.get(i[0]-1).add(i[1]-1);
            ind[i[1]-1]++;
        }
        for(int i=0;i<n;i++){
            if(ind[i]==0) {
                q.add(i);
                start[i] = 0;
            }
        }
        int ans = 0;
        while(!q.isEmpty()){
          
            int size = q.size();
            int max = 0;
            for(int i =0;i<size;i++) {
                int num = q.remove();

                for (int neb : al.get(num)) {
                    ind[neb] -= 1;
                    start[neb] = Math.max(start[neb], start[num] + time[num]);
                    if (ind[neb] == 0) {
                        q.add(neb);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(start));
        for(int i =0;i<n;i++){
            ans = Math.max(ans,start[i]+time[i]);
        }
        return ans;
    }
}