
    class Solution {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        Pair p = new Pair(0, 0);
        Queue<Pair> q = new ArrayDeque<>();
        q.add(p);
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true; // Mark the starting cell as visited
        return countSteps(q, grid, vis);
    }

    private int countSteps(Queue<Pair> q, int[][] grid, boolean[][] vis) {
        int n = grid.length;
        int ans = 1;
        int[] x = {-1, 0, 1, 1, 1, 0, -1, -1};
        int[] y = {-1, -1, -1, 0, 1, 1, 1, 0};
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair rev = q.remove();
                if (rev.x == n-1 && rev.y == n-1) return ans; 

                for (int j = 0; j < x.length; j++) {
                    int newX = rev.x + x[j];
                    int newY = rev.y + y[j];
                    
                    if (newX < 0 || newX >= n || newY < 0 || newY >= n || vis[newX][newY] || grid[newX][newY] == 1) {
                        continue;
                    }

                    vis[newX][newY] = true;
                    q.add(new Pair(newX, newY));
                }
            }
            ans++; 
        }
        return -1;
    }
}

