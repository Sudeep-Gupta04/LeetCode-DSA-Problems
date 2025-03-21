class Solution {
    public int trailingZeroes(int n) {
        if(n==0) return 0;
        int c =0;
        int c2 =0;
        int c5 =0;
        
        for(int i =1;i<=n;i++){
            List<Integer> al = getPrimeFactors(i);
            for(int num:al){
                if(num==2) c2++;
                else if(num==5) c5++;
            }

            c+=Math.min(c5,c2);
            c5-=Math.min(c5,c2);
            c2-=Math.min(c5,c2);
        }
        return c;
    }
 public static List<Integer> getPrimeFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        while (num % 2 == 0) {
            factors.add(2);
            num /= 2;
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        if (num > 2) {
            factors.add(num);
        }
        return factors;
    }

}