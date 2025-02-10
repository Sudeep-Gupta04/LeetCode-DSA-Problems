import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        
        int[][] effort = new int[r][c];
        for (int i = 0; i < r; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        
        effort[0][0] = 0;
        
        PriorityQueue<Cell> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.effort));
        pq.add(new Cell(0, 0, 0));
        
        int[] directions = {-1, 0, 1, 0};
        int[] directions2 = {0, 1, 0, -1};
        
        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int x = current.x;
            int y = current.y;
            int currentEffort = current.effort;

            if (x == r - 1 && y == c - 1) {
                return currentEffort;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + directions[i];
                int newY = y + directions2[i];
                
                if (newX >= 0 && newX < r && newY >= 0 && newY < c) {
                    int newEffort = Math.max(currentEffort, Math.abs(heights[x][y] - heights[newX][newY]));
                    
                    if (newEffort < effort[newX][newY]) {
                        effort[newX][newY] = newEffort;
                        pq.add(new Cell(newX, newY, newEffort));
                    }
                }
            }
            
        }

        return effort[r-1][c-1];
    }
}

class Cell {
    int x, y, effort;

    Cell(int x, int y, int effort) {
        this.x = x;
        this.y = y;
        this.effort = effort;
    }
}
