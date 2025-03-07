class Solution {
     public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = left;i<=right;i++){
            if(prime(i)) al.add(i);
        }
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