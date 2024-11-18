class Solution {
    public int tupleSameProduct(int[] nums) {
    HashMap<Long, Integer> mp = new HashMap<>();
    int c = 0;

    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length ; j++) {
            long product = (long) nums[i] * nums[j];
            if (mp.containsKey(product)) {
                c += (mp.get(product)) * 8;
                mp.put(product, mp.get(product) + 1);
            } else {
                mp.put(product, 1);
            }
        }
    }
    return c;
    }
}