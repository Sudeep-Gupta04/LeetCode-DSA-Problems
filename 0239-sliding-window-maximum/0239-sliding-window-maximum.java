class Solution {
    public static class Pairs implements Comparable<Pairs>{
        int value;
        int index;

        Pairs(int value , int index){
            this.value=value;
            this.index=index;
        }

        @Override
        public int compareTo(Pairs other) {
            return Integer.compare(this.value,other.value);
        }
    }

     public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
       int[] result = new int[n - k + 1];
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            while (!ad.isEmpty() && nums[ad.peekLast()] <= nums[i]) {
                ad.removeLast();
            }
            ad.add(i);
        }

        result[0] = nums[ad.peekFirst()];

        for (int i = k; i < n; i++) {
            if (ad.peekFirst() <= i - k) {
                ad.removeFirst();
            }
            while (!ad.isEmpty() && nums[ad.peekLast()] < nums[i]) {
                ad.removeLast();
            }
            ad.addLast(i);
            result[i - k + 1] = nums[ad.peekFirst()];
        }

        return result;
    }
}