class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int c = 0;
        Queue<Integer> pq = new ArrayDeque();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        for(int i =0;i<rooms.get(0).size();i++) {
            c++;
            pq.add(rooms.get(0).get(i));
            vis[rooms.get(0).get(i)] = true;
            System.out.println(rooms.get(0).get(i));
        }
        while(!pq.isEmpty()){
            int x = pq.remove();
            System.out.println(x);
            for(int i: rooms.get(x)){
                if(!vis[i]){
                    c++;
                    vis[i] = true;
                    pq.add(i);
                }
            }
        }
        System.out.println(c);
        return c==(n-1);
    }
}