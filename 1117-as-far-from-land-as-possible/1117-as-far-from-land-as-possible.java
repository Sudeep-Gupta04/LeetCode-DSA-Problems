class Pair {
            int x, y;
            public Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
class Solution {
        public int maxDistance(int[][] grid) {
            int n = grid.length;
            boolean[][] vis = new boolean[n][n];
            Queue<Pair> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        vis[i][j] = true;
                        q.add(new Pair(i, j));
                    }
                }
            }

            int c = -1;
            int[] x = {-1, 0, 1, 0};
            int[] y = {0, 1, 0, -1};

            while (!q.isEmpty()) {
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    Pair num = q.remove();
                    for (int i = 0; i < 4; i++) {
                        int newx = num.x + x[i];
                        int newy = num.y + y[i];
                        if (newx >= 0 && newx < n && newy >= 0 && newy < n && !vis[newx][newy]) {
                            vis[newx][newy] = true;
                            q.add(new Pair(newx, newy));
                        }
                    }
                }
                c++;
            }

            return c == 0 ? -1 : c;
        }

}