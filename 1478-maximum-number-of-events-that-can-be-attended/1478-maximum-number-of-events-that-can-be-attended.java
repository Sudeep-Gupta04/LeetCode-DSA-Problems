import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Point[] arr = new Point[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Point(events[i][0], events[i][1]);
        }

        Arrays.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.y == p2.y) return p1.x - p2.x;
                return p1.y - p2.y;
            }
        });

        int c = 0;
        TreeSet<Integer> hs = new TreeSet<>();
        for (int i = 1; i <= 100000; i++) hs.add(i);

        for (int i = 0; i < n; i++) {
            int st = arr[i].x;
            int en = arr[i].y;

            Integer day = hs.ceiling(st);
            if (day != null && day <= en) {
                c++;
                hs.remove(day);
            }
        }

        return c;
    }
}

class Point {
    int x, y;
    Point(int s, int e) {
        this.x = s;
        this.y = e;
    }
}
