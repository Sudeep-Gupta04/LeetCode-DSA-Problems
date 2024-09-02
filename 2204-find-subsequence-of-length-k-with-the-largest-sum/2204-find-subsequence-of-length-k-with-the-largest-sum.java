class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
    // Priority queue to keep the k largest elements based on value
    PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Integer.compare(p1.x, p2.x);
        }
    });
    
    for (int i = 0; i < nums.length; i++) {
        pq.add(new Pair(nums[i], i));
        if (pq.size() > k) {
            pq.remove();
        }
    }

    // Extract pairs into an array
    Pair[] arr = new Pair[pq.size()];
    int i = 0;
    while (!pq.isEmpty()) {
        arr[i++] = pq.remove();
    }

    // Sort the array based on the second value (index)
    Arrays.sort(arr, new Comparator<Pair>() {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Integer.compare(p1.y, p2.y);
        }
    });

    // Extract the values into the result array
    int[] ans = new int[arr.length];
    for (int a = 0; a < arr.length; a++) {
        ans[a] = arr[a].x;
    }
    
    return ans;
}

// Definition of the Pair class
class Pair {
    int x; // Value
    int y; // Index

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

}