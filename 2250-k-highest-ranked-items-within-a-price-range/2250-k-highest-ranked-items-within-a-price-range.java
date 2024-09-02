import java.util.*;

class Solution {

    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    List<List<Integer>> main = new ArrayList<>();

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        List<List<Pair>> ll = new ArrayList<>();
        Queue<Pair> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        q.add(new Pair(start[0], start[1]));
        vis[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            List<Pair> l = new ArrayList<>();
            int size = q.size();
            int[] x = {0, 1, 0, -1};
            int[] y = {-1, 0, 1, 0};

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                
                if (grid[p.x][p.y] >= pricing[0] && grid[p.x][p.y] <= pricing[1]) {
                    l.add(p);
                }
                
                for (int z = 0; z < x.length; z++) {
                    int newX = p.x + x[z];
                    int newY = p.y + y[z];
                    
                    if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || vis[newX][newY] || grid[newX][newY] == 0) {
                        continue;
                    }
                    
                    q.add(new Pair(newX, newY));
                    vis[newX][newY] = true; // Mark as visited after adding to queue
                }
            }

            if (l.size() >= k) {
                compute(l, grid, k, 1);
                return main;
            } else {
                k = k - l.size();
                compute(l, grid, k, 0);
            }
        }

        return main;
    }

    class ele {
        int value;
        Pair p;

        public ele(int value, Pair p) {
            this.value = value;
            this.p = p;
        }
    }

    class EleComparator implements Comparator<ele> {
        @Override
        public int compare(ele e1, ele e2) {
            if (e1.value != e2.value) {
                return Integer.compare(e1.value, e2.value);
            }
            if (e1.p.x != e2.p.x) {
                return Integer.compare(e1.p.x, e2.p.x);
            }
            return Integer.compare(e1.p.y, e2.p.y);
        }
    }

    public void compute(List<Pair> l, int[][] grid, int k, int check) {
        List<ele> com = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            Pair p = l.get(i);
            com.add(new ele(grid[p.x][p.y], p));
        }
        Collections.sort(com, new EleComparator());

        int limit = check == 1 ? k : l.size();
        for (int i = 0; i < limit; i++) {
            List<Integer> x = new ArrayList<>();
            ele e = com.get(i);
            x.add(e.p.x);
            x.add(e.p.y);
            main.add(new ArrayList<>(x));
        }
    }
}
