class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        ArrayList<int[]> al = new ArrayList();
        for(int i =0;i<n;i++){
            al.add(new int[]{efficiency[i],speed[i]});
        }
        Collections.sort(al, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2){
                return o1[0]-o2[0]; // sort on the basis of effecency
            }
        });
        int pqsize = k-1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // push last k-1 ellemets;
        long lastksum = 0;
        int i = n-1;
        int mod = (int) 1e9 + 7;
        long ans = 0;
        for(;i>=n-pqsize;i--){
            int spd = al.get(i)[1];
            ans = Math.max(ans,(lastksum + al.get(i)[1]) * al.get(i)[0]);
            pq.add(spd);
            lastksum += spd;
        }

        for(;i>=0;i--){
            ans = (Math.max(ans,(lastksum + al.get(i)[1]) * al.get(i)[0]));
            pq.add(al.get(i)[1]);
            lastksum += (al.get(i)[1] - pq.remove());
        }
        return (int)(ans%mod);
    }
}