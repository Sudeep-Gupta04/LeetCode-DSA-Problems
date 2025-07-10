class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        int[] gap = new int[n-1];
        for(int i =0;i<n-1;i++){
            gap[i] = Math.max(0,heights[i+1] - heights[i]);
        }
       // System.out.println(Arrays.toString(gap));
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap for toatl sum of max k elemetns;
        int tsum=0;
        int sum=0;
        for(int i =0;i<n-1;i++){
            tsum += gap[i];
            sum += gap[i];
            pq.add(gap[i]);
            if(pq.size()>ladders) sum -= pq.remove();
           // System.out.println(sum+ " "+tsum);
            if(tsum-sum>bricks) return i;
        }
        return n-1;
    }
}