class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if (hm.containsKey(rem)) {
                ans += hm.get(rem);
            }
            hm.put(rem, hm.getOrDefault(rem, 0) + 1);
        }

        return ans;
    }
}