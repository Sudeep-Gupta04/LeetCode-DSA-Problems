public class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        int res=0;
        for(int i=0;i<nums.length;i++){
            pq.add((long)nums[i]);
        }
        while(!pq.isEmpty()){
            long min1=pq.poll();
            if(min1>=k){
                return res;
            }
            long min2=pq.poll();
            pq.add((long) 2*Math.min(min1, min2)+Math.max(min1, min2));
            res++;
        }
        return res;
    }
}
