class Solution {
    class Pair implements Comparable<Pair> {
        Integer idx;
        Integer val;

        public Pair(Integer idx, Integer val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Pair other) {
            int charComparison = Integer.compare(this.val, other.val);
            if (charComparison != 0) {
                return charComparison;
            }
            return this.idx.compareTo(other.idx);
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i =0;i<nums.length;i++){
            pq.add(new Pair(i,nums[i]));
        }
        while (k-->0){
            Pair temp = pq.remove();
            nums[temp.idx] = multiplier*nums[temp.idx];
            pq.add(new Pair(temp.idx,nums[temp.idx]));
        }
        return nums;
    }
}