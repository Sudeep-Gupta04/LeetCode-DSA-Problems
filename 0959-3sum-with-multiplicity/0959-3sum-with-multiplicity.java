class Solution {
    public int threeSumMulti(int[] arr, int target) {
    int n = arr.length;
    long ans = 0;
    final int MOD = 1000000007; 
    for (int i = 0; i < n; i++) {
        int tt = target - arr[i];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int j = i + 1; j < n; j++) {
            int key = tt - arr[j];
            if (hm.containsKey(key)) {
                ans = (ans + hm.get(key)) % MOD;
            }
            hm.put(arr[j], hm.getOrDefault(arr[j], 0) + 1);
        }
    }
    return (int) ans; // Cast the final answer to int
}

}