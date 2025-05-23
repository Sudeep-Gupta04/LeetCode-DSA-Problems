class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer,ArrayList<Integer>> mp = new HashMap<>();
        for(int i=0;i<routes.length;i++){
            int[] arr = routes[i];
            for(int sta:arr){
                if (!mp.containsKey(sta)) {
                    mp.put(sta, new ArrayList<>(Arrays.asList(i)));
                } else {
                    mp.get(sta).add(i);
                }
            }
        }
        // for (Map.Entry<Integer, ArrayList<Integer>> entry : mp.entrySet()) {
        //     System.out.println(entry.getKey() + " -> " + entry.getValue());
        // }

        HashSet<Integer> vis = new HashSet<>();
        HashSet<Integer> busvis = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        vis.add(source);
        int lv =0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int nod = q.remove();
                if(nod==target) return lv;
                ArrayList<Integer> buses = mp.get(nod);
                if (buses == null || buses.isEmpty()) continue;
                for(int bus:buses){
                   if(busvis.contains(bus)) continue;
                   busvis.add(bus);
                   int[] station = routes[bus];
             //    System.out.println(Arrays.toString(station));
                   for(int st:station){
                       if(!vis.contains(st)){
                           vis.add(st);
                           q.add(st);
                       }
                   }
                }
            }
          //  System.out.println(q);
            lv++;
        }
        return -1;
    }
}