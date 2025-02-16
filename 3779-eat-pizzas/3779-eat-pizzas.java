class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int n = pizzas.length;
        int size = n / 4;
        System.out.println(size);
        int k = n - 1;
        long ans = 0; // Changed to long

        for (int i = 1; i <= Math.ceil(size / 2.0); i++) {
            ans += pizzas[k--];
        }
        
        System.out.println(k);
        k--;

        int rem = size - (int) Math.ceil(size / 2.0);
        for (int i = 1; i <= rem; i++) {
            ans += pizzas[k];
            k -= 2;
        }

        return ans;
    }
}
