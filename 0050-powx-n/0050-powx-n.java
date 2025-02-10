import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x,n);
        // if (n == 0) return 1.0;
        // if (n > 0) return positive(BigDecimal.valueOf(x), n).doubleValue();
        // else {
        //     BigDecimal find = positive(BigDecimal.valueOf(x), -n);
        //     return BigDecimal.ONE.divide(find, 15, RoundingMode.HALF_UP).doubleValue();
        // }
    }

    public BigDecimal positive(BigDecimal x, int n) {
        BigDecimal result = BigDecimal.ONE;
        BigDecimal base = x;

        while (n > 0) {
            if (n % 2 == 1) result = result.multiply(base);
            base = base.multiply(base);
            n /= 2;
        }

        return result;
    }
}
