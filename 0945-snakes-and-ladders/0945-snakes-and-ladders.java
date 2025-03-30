class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int moves = 0;
        boolean[] visited = new boolean[n * n + 1]; 
        visited[1] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int pos = q.poll();
                if (pos == n * n) return moves;
                
                for (int dice = 1; dice <= 6; dice++) {
                    int next = pos + dice;
                    if (next > n * n) break;

                    int[] coords = getCoordinates(next, n);
                    int r = coords[0], c = coords[1];

                    if (board[r][c] != -1) {
                        next = board[r][c];
                    }
                    
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] getCoordinates(int pos, int n) {
        int row = (pos - 1) / n;
        int col = (pos - 1) % n;
        int x = n - 1 - row;
        int y;
        if (row % 2 == 0) {
            y = col;
        } else {
            y = n - 1 - col;
        }
        return new int[]{x, y};
    }
}
