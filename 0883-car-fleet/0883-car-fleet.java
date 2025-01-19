import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(position[i], speed[i]);
        }
        // Use an anonymous comparator to sort the array
        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.dis == o2.dis) {
                    return o2.speed - o1.speed;  // Descending order for speed if distances are equal
                }
                return o1.dis - o2.dis;  // Ascending order for distance
            }
        });

        System.out.println(Arrays.toString(arr));

        int c = 1;
        // double timeToReach = (double) (target - arr[n - 1].dis) / arr[n - 1].speed;
        // for (int i = n - 2; i >= 0; i--) {
        //     double currentTime = (double) (target - arr[i].dis) / arr[i].speed;
        //     if (currentTime > timeToReach) {
        //         c++;
        //         timeToReach = currentTime;
        //     }
        // }
        double recht = (double) (target - arr[n - 1].dis) / arr[n - 1].speed;
        for (int i = n - 2; i >= 0; i--) {
        double currentTime = (double) (target - arr[i].dis) / arr[i].speed;
        if (currentTime > recht) {
        c++;
        recht = currentTime;
            }
        }

        return c;
    }

    public class Pair {
        int dis;
        int speed;

        public Pair(int dis, int speed) {
            this.dis = dis;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "Pair{" + "dis=" + dis + ", speed=" + speed + '}';
        }
    }
}
