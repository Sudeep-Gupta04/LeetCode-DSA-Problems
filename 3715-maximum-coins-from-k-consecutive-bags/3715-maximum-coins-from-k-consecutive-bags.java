import java.util.Arrays;

class Pair implements Comparable<Pair> {
    long x, y, z;
    
    public Pair(long x, long y, long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public int compareTo(Pair other) {
        return Long.compare(this.x, other.x);
    }
}

public class Solution {
    public long maximumCoins(int[][] coins, long k) {
        if (coins.length == 1) {
            long min = Math.min(k, coins[0][1] - coins[0][0] + 1);
            return min * coins[0][2];
        }
        
        Pair[] arr = new Pair[coins.length];
        for (int i = 0; i < coins.length; i++) {
            arr[i] = new Pair(coins[i][0], coins[i][1], coins[i][2]);
        }
        
        Arrays.sort(arr);
        long fans = 0;
        long c = 0;
        int s = 0, e = 0;
        
        while (e < arr.length) {
            while (s < arr.length && arr[s].y < arr[e].x + k) {
                c += arr[s].z * (arr[s].y - arr[s].x + 1);
                s++;
            }
            if (s < arr.length) {
                long part = Math.max(0, arr[e].x + k - arr[s].x) * arr[s].z;
                fans = Math.max(fans, c + part);
            }
            c -= arr[e].z * (arr[e].y - arr[e].x + 1);
            e++;
        }
        
        s = 0;
        e = 0;
        c = 0;
        
        while (e < arr.length) {
            c += arr[e].z * (arr[e].y - arr[e].x + 1);
            while (s < arr.length && arr[s].y < arr[e].y - k + 1) {
                c -= arr[s].z * (arr[s].y - arr[s].x + 1);
                s++;
            }
            long part = (s < arr.length) ? Math.max(0, arr[e].y - k - arr[s].x + 1) * arr[s].z : 0;
            fans = Math.max(fans, c - part);
            e++;
        }
        
        return fans;
    }
}
