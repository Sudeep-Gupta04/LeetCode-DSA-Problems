class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) return o1[0] - o2[0];    // {index, weight}
                return o1[1] - o2[1];
            }
        });
        int m = servers.length;
        int n = tasks.length;

        ArrayList<int[]> temp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            temp.add(new int[]{i, servers[i]});
        }
        TreeMap<Integer, ArrayList<int[]>> hm = new TreeMap<>();
        hm.put(0, temp);

        int[] ans = new int[n];
        int curTime = 0;

        for (int i = 0; i < n; i++) {
            if (hm.containsKey(i)) {
                for (int[] server : hm.get(i)) pq.add(server);
                hm.remove(i);
            }

            if (pq.isEmpty()) {
                Integer nextTime = hm.ceilingKey(i);
                if (nextTime != null) {
                    for (int[] server : hm.get(nextTime)) pq.add(server);
                    hm.remove(nextTime);
                    curTime = Math.max(curTime, nextTime);
                }
            }
            curTime = Math.max(curTime, i); 
            int[] server = pq.remove();
            ans[i] = server[0];
            int nextfreetime = curTime + tasks[i];
            hm.computeIfAbsent(nextfreetime, k -> new ArrayList<>()).add(server);
        }
        return ans;
    }
}