class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int n = points.length;
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            index.add(points[i][0]);
        }

        TreeSet<Pair> tm = new TreeSet<>((o1, o2) -> {
            int x1 = o1.point[0], y1 = o1.point[1];
            int x2 = o2.point[0], y2 = o2.point[1];
            int cmp = (x2 + y2) - (x1 + y1); 
            if (cmp == 0) return o1.x - o2.x; 
            return cmp;
        });

        int idx = Collections.binarySearch(index, points[0][0] + k);
        int floorIndex = (idx >= 0) ? idx : -idx - 2;

        int max = Integer.MIN_VALUE;

        for (int j = 1; j <= floorIndex; j++) {
            tm.add(new Pair(j, new int[]{points[j][0], points[j][1]}));
        }

        if (!tm.isEmpty()) {
            int[] best = tm.first().point;
            max = Math.max(max, points[0][1] + best[1] + (best[0] - points[0][0]));
        }

        for (int i = 1; i < n; i++) {
            int newidx = Collections.binarySearch(index, points[i][0] + k);
            int newfloorIndex = (newidx >= 0) ? newidx : -newidx - 2;

            for (int j = floorIndex + 1; j <= Math.min(n - 1, newfloorIndex); j++) {
                tm.add(new Pair(j, new int[]{points[j][0], points[j][1]}));
            }

            floorIndex = newfloorIndex;
            tm.remove(new Pair(i, points[i])); 

            if (!tm.isEmpty()) {
                int[] best = tm.first().point;
                max = Math.max(max, points[i][1] + best[1] + (best[0] - points[i][0]));
            }
        }

        return max;
    }

    static class Pair {
        int x;
        int[] point;

        Pair(int x, int[] point) {
            this.x = x;
            this.point = point;
        }
    }
}
