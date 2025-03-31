class Point {
    int x;
    int[] arr;

    Point(int x, int[] arr) {
        this.x = x;
        this.arr = arr;
    }
}

public class Solution {
   public long putMarbles(int[] weights, int k) {
        // Min Heap (Smallest x first)
        PriorityQueue<Point> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.x));
        // Max Heap (Largest x first)
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.x, a.x));
        
        for (int i = 0; i < weights.length - 1; i++) {
            maxHeap.add(new Point(weights[i] + weights[i + 1], new int[]{1, i}));
            minHeap.add(new Point(weights[i] + weights[i + 1], new int[]{1, i}));
        }
        
        HashSet<Integer> maxmp = new HashSet<>();
        int c = k - 1;
        long max = 0;
        while (!maxHeap.isEmpty() && c > 0) {
            Point p = maxHeap.remove();
            if (!maxmp.contains(p.arr[1])) {
                max += p.x;
                maxmp.add(p.arr[1]);
                c--;
            }
        }
        
        HashSet<Integer> minmp = new HashSet<>();
        c = k - 1;
        long min = 0;
        while (!minHeap.isEmpty() && c > 0) {
            Point p = minHeap.remove();
            if (!minmp.contains(p.arr[1])) {
                min += p.x;
                minmp.add(p.arr[1]);
                c--;
            }
        }
        
        return max - min;
    }
    
    
}