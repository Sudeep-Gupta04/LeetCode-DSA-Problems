class Solution {
    public static ArrayList<Integer> findPrimesInRange(int low, int high) {
        ArrayList<Integer> primes = new ArrayList<>();
        if (low > high) return primes;

        int sqrtHigh = (int) Math.sqrt(high);
        boolean[] isPrime = new boolean[sqrtHigh + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= sqrtHigh; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= sqrtHigh; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> basePrimes = new ArrayList<>();
        for (int i = 2; i <= sqrtHigh; i++) {
            if (isPrime[i]) basePrimes.add(i);
        }

        boolean[] isPrimeInRange = new boolean[high - low + 1];
        Arrays.fill(isPrimeInRange, true);

        for (int prime : basePrimes) {
            int start = Math.max(prime * prime, (low + prime - 1) / prime * prime);
            for (int j = start; j <= high; j += prime) {
                isPrimeInRange[j - low] = false;
            }
        }

        for (int i = 0; i < isPrimeInRange.length; i++) {
            if (isPrimeInRange[i] && (i + low) > 1) {
                primes.add(i + low);
            }
        }

        return primes;
    }
     public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> al = findPrimesInRange(left,right);
        if(al.size()<2){
            return new int[]{-1,-1};
        }
        int[] ans = new int[2];
        int dif = 100000;
        for(int i =0;i<al.size()-1;i++){
            if(al.get(i+1)-al.get(i)<dif){
                dif = al.get(i+1)-al.get(i);
                ans[0] = al.get(i);
                ans[1] = al.get(i+1);
            }
        }
        return ans;

    }
    public boolean prime(int num) {
        if (num < 2) return false; // 0 and 1 are not prime numbers
        for (int i = 2; i * i <= num; i++) { // Check divisibility up to sqrt(num)
            if (num % i == 0) return false; // If divisible, it's not prime
        }
        return true; // If no divisors found, it's prime
    }
}