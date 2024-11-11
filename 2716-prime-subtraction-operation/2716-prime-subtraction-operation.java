class Solution {
    public boolean primeSubOperation(int[] nums) {
        int limit = 1000;
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        int k =0;
        for(int i = nums.length-1;i>=1;i--){
            if(nums[i]<=nums[i-1]){
                while(nums[i-1]>=nums[i]){
                    if(k==primes.size()){
                        
                         return false;
                    }
                    if(nums[i-1] - primes.get(k++)<nums[i]){
                        // System.out.println(nums[i-1]);
                        nums[i-1] = nums[i-1] - primes.get(k-1);
                        // System.out.println(nums[i-1]);
                        
                    }
                }
                if(nums[i-1]<=0){
                    System.out.println("execyted");
                    return false;
                }
                k = 0;
            }
            // System.out.println(nums[i]);
            
        }
        return true;
    }
}