class Point implements Comparable<Point> {
    public int x; // x-coordinate
    public int y; // y-coordinate

    // Constructor for Point
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Define natural ordering for PriorityQueue as max-heap based on y
    @Override
    public int compareTo(Point other) {
        if (this.y == other.y) return this.x - other.x;
        return other.y - this.y;
    }

    // Override equals, hashCode, and toString as before
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return (x == point.x && y == point.y) || (x == point.y && y == point.x);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Math.min(x, y), Math.max(x, y));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // No comparator needed in PriorityQueue since Point now implements Comparable
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < items.length; i++) {
            Point p = new Point(items[i][0], items[i][1]);
            pq.add(p);
        }

        int[] ans = new int[queries.length];
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int i = 0; i < queries.length; i++) {
            int num = queries[i];
            if (hs.containsKey(num)) {
                ans[i] = hs.get(num);
                continue;
            }
            Queue<Point> q = new ArrayDeque<>();
            while (!pq.isEmpty() && pq.peek().x > num) {
                q.add(pq.poll());
            }
            if (!pq.isEmpty()) {
                ans[i] = pq.peek().y;
            } else {
                ans[i] = 0;
            }
            hs.put(num, ans[i]);
            while (!q.isEmpty()) pq.add(q.remove());
        }
        return ans;
    }
}
