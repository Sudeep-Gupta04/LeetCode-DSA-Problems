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
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int pa = Integer.MIN_VALUE;
        HashSet<Pair> hs = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            hs.add(new Pair(obstacles[i][0], obstacles[i][1]));
        }

        int x = 0, y = 0, s = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] < 0) {
                if (commands[i] == -2) {
                    s = s - 1;
                    if (s < 0) s = (s + 4) % 4;  // Fix to keep s within bounds
                } else if (commands[i] == -1) {
                    s = (s + 1) % 4;
                }
            } else {
                int k = commands[i];
                if (s == 0) { // North
                    for (int j = 0; j < k; j++) {
                        y++;
                        if (hs.contains(new Pair(x, y))) {
                            y--;
                            break;
                        }
                    }
                } else if (s == 1) { // East
                    for (int j = 0; j < k; j++) {
                        x++;
                        if (hs.contains(new Pair(x, y))) {
                            x--;
                            break;
                        }
                    }
                } else if (s == 2) { // South
                    for (int j = 0; j < k; j++) {
                        y--;
                        if (hs.contains(new Pair(x, y))) {
                            y++;
                            break;
                        }
                    }
                } else { // West
                    for (int j = 0; j < k; j++) {
                        x--;
                        if (hs.contains(new Pair(x, y))) {
                            x++;
                            break;
                        }
                    }
                }
            }
            System.out.println(x + " " + y + " " + s);
            pa = Math.max(pa, x * x + y * y);
        }
        return pa;
    }
}

