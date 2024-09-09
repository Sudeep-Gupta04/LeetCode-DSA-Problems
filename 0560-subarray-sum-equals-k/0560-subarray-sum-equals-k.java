class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            pre[i] = sum;
        }

        HashMap<Integer, Integer> mp = new HashMap<>();
        int c = 0;
        mp.put(0, 1);

        for (int i = 0; i < pre.length; i++) {
            if (mp.containsKey(pre[i] - k)) {
                c += mp.get(pre[i] - k);
            }

            mp.put(pre[i], mp.getOrDefault(pre[i], 0) + 1);
        }

        return c;
    }
}
