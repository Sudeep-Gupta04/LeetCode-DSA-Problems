import java.util.*;

class Point {
    long x, y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Point>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) al.add(new ArrayList<>());

        for (int i = 0; i < roads.length; i++) {
            int x = roads[i][0], y = roads[i][1], wt = roads[i][2];
            al.get(x).add(new Point(y, wt));
            al.get(y).add(new Point(x, wt));
        }

        long[] dis = new long[n];
        long[] count = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        count[0] = 1;
        dis[0] = 0;

        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.y));
        pq.add(new Point(0, 0));

        while (!pq.isEmpty()) {
            Point p = pq.poll();


            for (Point i : al.get((int) p.x)) {
                long cstReachingX = p.y + i.y;
                if (cstReachingX < dis[(int) i.x]) {
                    count[(int) i.x] = count[(int) p.x] % 1_000_000_007;
                    dis[(int) i.x] = cstReachingX;
                    pq.add(new Point(i.x, dis[(int) i.x]));
                } else if (cstReachingX == dis[(int) i.x]) {
                    count[(int) i.x] = (count[(int) i.x] + count[(int) p.x]) % 1_000_000_007;
                }
            }
        }
        return (int) count[n - 1];
    }
}
