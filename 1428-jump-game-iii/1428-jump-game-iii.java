class Solution {
    public boolean canReach(int[] arr, int start) {
            Queue<Integer> q = new ArrayDeque();
            q.add(start);
            
            int n = arr.length;
            boolean [] vis = new boolean[n];
            vis[start] = true;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    int num = q.remove();
                    if(arr[num]==0) return true;
                    int p1 = num+arr[num];
                    int p2 = num-arr[num];
                    if(p1>=0 && p1<n && !vis[p1]){
                        vis[p1] = true;
                        q.add(p1);
                    }
                    if(p2>=0 && p2<n && !vis[p2]){
                        vis[p2] = true;
                        q.add(p2);
                    }
                }
            }
        return false;
    }
}