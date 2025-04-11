import java.util.HashSet;

class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        
        if (target > x + y) return false;

        // int[] arr = new int[3];
        // arr[0] = x;
        // arr[1] = y;
        // arr[2] = Math.abs(x - y);

        // HashSet<Integer> hs = new HashSet<>();
        // for (int i = 0; i < 3; i++) {
        //     int num = arr[i];
        //     while(num<=(x+y)){
        //         hs.add(num);
        //         num*=2;
        //     }
        //     if (i != 2) hs.add(arr[i] + arr[i + 1]);
        // }
        // hs.add(arr[0] + arr[2]);
        int g = gcd(x,y);
        return  target%g==0?true:false;
    }
    public int gcd(int a, int b) {
    if (b == 0)
        return a;
    return gcd(b, a % b);
    }
}
