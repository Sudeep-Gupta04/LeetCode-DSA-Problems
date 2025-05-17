class Solution {
        public int minJumps(int[] arr) {
        
        int n = arr.length;
        if(n==1) return 0;
        boolean[] vis = new boolean[n];
        HashMap<Integer,ArrayList> hm = new HashMap<>();
        for(int i =0;i<n;i++){
            hm.putIfAbsent(arr[i], new ArrayList<>());
            hm.get(arr[i]).add(i);
        }
        Queue<Integer> q = new ArrayDeque();
        q.add(0);
        vis[0] = true;
        int lv = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                
                int idx = q.remove();

                if(idx > 0 && !vis[idx - 1]){
                    vis[idx -1] = true;
                    q.add(idx -1);
                }
                if(idx < n-1 && !vis[idx+1]){
                    vis[idx +1] = true;
                    q.add(idx +1);
                }
                if(hm.containsKey(arr[idx])){
                    for(Object j:hm.get(arr[idx])){
                        if((Integer) j!=idx && !vis[(Integer)j]){
                            vis[(Integer) j] = true;
                            q.add((Integer) j);
                        }
                    }
                }
                hm.remove(arr[idx]);
            }
            if(vis[n-1]) return lv + 1;
            lv++;
        }
        return n-1;
    }
}