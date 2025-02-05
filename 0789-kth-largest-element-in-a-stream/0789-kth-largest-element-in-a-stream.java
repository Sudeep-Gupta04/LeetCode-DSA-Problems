
class KthLargest {
    PriorityQueue<Integer> pq;
    static int size=0;
    public KthLargest(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue<>();
        for(int i =0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k) pq.remove();
        };
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size()>size) pq.remove();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */