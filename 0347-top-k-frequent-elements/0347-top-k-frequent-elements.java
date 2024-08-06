class Solution {
      public static class reverse_insertion implements Comparable<reverse_insertion> {
        int key;
        int value;

        public reverse_insertion(Map.Entry<Integer, Integer> entryset) {
            this.key = entryset.getKey();
            this.value = entryset.getValue();
        }

        @Override
        public int compareTo(reverse_insertion other) {
            return Integer.compare(this.value, other.value);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }


        PriorityQueue<reverse_insertion> pq = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            pq.add(new reverse_insertion(entry));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll().key;
        }

        return result;
    }

}