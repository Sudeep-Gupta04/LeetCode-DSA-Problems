import java.util.HashSet;
import java.util.Objects;

class Solution {
    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int pa = Integer.MIN_VALUE;
        HashSet<Pair> hs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            hs.add(new Pair(obstacle[0], obstacle[1]));
        }

        int x = 0, y = 0, s = 0;
        for (int command : commands) {
            if (command < 0) {
                if (command == -2) {
                    s = (s - 1 + 4) % 4; // Turn left
                } else if (command == -1) {
                    s = (s + 1) % 4; // Turn right
                }
            } else {
                int k = command;
                if (s == 0) { // North
                    for (int j = 0; j < k; j++) {
                        if (hs.contains(new Pair(x, y + 1))) break;
                        y++;
                    }
                } else if (s == 1) { // East
                    for (int j = 0; j < k; j++) {
                        if (hs.contains(new Pair(x + 1, y))) break;
                        x++;
                    }
                } else if (s == 2) { // South
                    for (int j = 0; j < k; j++) {
                        if (hs.contains(new Pair(x, y - 1))) break;
                        y--;
                    }
                } else { // West
                    for (int j = 0; j < k; j++) {
                        if (hs.contains(new Pair(x - 1, y))) break;
                        x--;
                    }
                }
            }
            pa = Math.max(pa, x * x + y * y);
        }
        return pa;
    }
}
