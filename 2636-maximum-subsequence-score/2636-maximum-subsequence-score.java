class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[] efficiency = nums2;
        int[] speed = nums1;
        int n = speed.length;
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
        PriorityQueue<Long> pq = new PriorityQueue<>();
        // push last k-1 ellemets;
        long lastksum = 0;
        int i = n-1;
        for(;i>=n-pqsize;i--){
            long spd = al.get(i)[1];
            pq.add(spd);
            lastksum += spd;
        }
        long ans = 0;
        for(;i>=0;i--){
            ans = (Math.max(ans,(lastksum + al.get(i)[1]) * al.get(i)[0]));
            pq.add((long) al.get(i)[1]);
            lastksum += (al.get(i)[1] - pq.remove());
        }
        return ans;
    }
}