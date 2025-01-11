public class Solution {
    public long numberOfSubsequences(int[] n) {
        long res = 0;
        Map<Pair, Integer> cnt = new HashMap<>();
        for (int q = n.length - 5; q > 1; --q) {
            for (int s = q + 4, r = q + 2; s < n.length; ++s) {
                int f = gcd(n[r], n[s]);
                Pair key = new Pair(n[r] / f, n[s] / f);
                cnt.put(key, cnt.getOrDefault(key, 0) + 1);
            }
            for (int p = 0; p + 1 < q; ++p) {
                int f = gcd(n[p], n[q]);
                Pair key = new Pair(n[q] / f, n[p] / f);
                res += cnt.getOrDefault(key, 0);
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static class Pair {
        int num1;
        int num2;

        Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return num1 == pair.num1 && num2 == pair.num2;
        }

        @Override
        public int hashCode() {
            return 31 * num1 + num2;
        }
    }
}
