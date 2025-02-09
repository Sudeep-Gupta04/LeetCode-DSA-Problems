import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dis = new int[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        dis[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int[] x = {0, 1, 0, -1};
            int[] y = {1, 0, -1, 0};

            for (int k = 0; k < 4; k++) {
                int newx = p.x + x[k];
                int newy = p.y + y[k];

                if (newx >= 0 && newx < r && newy >= 0 && newy < c) {
                    if (dis[newx][newy] > Math.max(grid[newx][newy], Math.max(grid[p.x][p.y], dis[p.x][p.y]))) {
                        pq.add(new Pair(newx, newy));
                        dis[newx][newy] = Math.max(grid[newx][newy], Math.max(grid[p.x][p.y], dis[p.x][p.y]));
                    }
                }
            }
        }
        return dis[r - 1][c - 1];
    }
}

class Pair implements Comparable<Pair> {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair other) {
        return 0; // No priority logic added since original code didn't specify it
    }
}
