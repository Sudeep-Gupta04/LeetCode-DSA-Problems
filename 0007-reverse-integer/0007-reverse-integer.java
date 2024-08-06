class Solution {
    public static int reverse(int x) {
        StringBuffer num = new StringBuffer();
        boolean isNegative = x < 0;

        num.append(Math.abs(x));
        num.reverse();

        try {
            int reversed = Integer.parseInt(num.toString());
            if(isNegative) return -1 * reversed;
            else return reversed;
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}