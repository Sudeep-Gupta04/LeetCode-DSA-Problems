class Solution {
     public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i =0;i<=n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] i:edges){
            al.get(i[0]).add(i[1]);
            al.get(i[1]).add(i[0]);
        }
        int[] fmax = new int[n+1];
        int[] smax = new int[n+1];
        Arrays.fill(fmax,Integer.MAX_VALUE);
        Arrays.fill(smax,Integer.MAX_VALUE);
        fmax[1] = 0;
        smax[1] = 0;

        dijtras(al,fmax,time,change);
        System.out.println(Arrays.toString(fmax));
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        pq.add(new int[]{0,1});
        while(!pq.isEmpty()){
            int[] t = pq.poll();
            int curtime = t[0];
            int curnod = t[1];
            System.out.println(curtime+" "+curnod+" POP");
            int waitTime;
            int signal = (int) Math.floor(curtime/(double)change);
            if(signal%2==0){
                waitTime =0;
            }
            else {
                if(curtime%change==0) waitTime = change;
                else waitTime = (int)Math.ceil(curtime/(double)change) * change - curtime;
            }
            for(int i:al.get(curnod)){
                int reachi = curtime + waitTime+time;
                if((smax[i]==fmax[i]) || (reachi >= fmax[i] && reachi<smax[i])){
                    System.out.println(curnod+" "+i);
                    smax[i] = reachi;
                    pq.add(new int[]{reachi,i});
                }
            }
        }
        System.out.println(Arrays.toString(smax));
        return smax[n];
    }
    public void dijtras(ArrayList<ArrayList<Integer>> al,int[] max,int time, int change){
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return  o1[0]-o2[0];
            }
        });

        pq.add(new int[]{0,1});
        while(!pq.isEmpty()){
            int[] t = pq.poll();
            int curtime = t[0];
            int curnod = t[1];
            int waitTime;
            int signal = (int) Math.floor(curtime/(double)change);
            if(signal%2==0){
                waitTime =0;
            }
            else {
                if(curtime%change==0) waitTime = change;
                else waitTime = (int)Math.ceil(curtime/(double)change) * change - curtime;
            }
            for(int i:al.get(curnod)){
                int reachi = max[curnod]+waitTime+time;
                if(reachi<=max[i]){
                    max[i] = reachi;
                    pq.add(new int[]{reachi,i});
                }
            }
        }
    }
}