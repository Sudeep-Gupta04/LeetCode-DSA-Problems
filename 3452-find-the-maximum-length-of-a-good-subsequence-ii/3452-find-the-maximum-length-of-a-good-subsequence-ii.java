class Solution {
    public int maximumLength(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        CustomMaxMap<Integer> cm = new CustomMaxMap<>();
        int n = nums.length;
        int[][] dp = new int[k+1][n];

        for(int i =0;i<k+1;i++){
            dp[i][0] = 1;
        }
        for(int i =0;i<n;i++){
            cm.putOrIncrement(nums[i]);
            dp[0][i] = cm.getMaxValue();
        }

        for(int i =1;i<k+1;i++){
            int max = 1;
            for(int j =1;j<n;j++){
                max = Math.max(max,1 + dp[i-1][j-1]);
                int p1 = max;
                int p2 = 0;
                int idx = -1;
                if(hm.containsKey(nums[j])) idx = hm.get(nums[j]);
                if(idx!=-1){
                    p2 = 1 + dp[i][idx];
                }
                dp[i][j] = Math.max(p1,p2);
                hm.put(nums[j],j);
            }
            hm.clear();
        }
        // for(int i =0;i<k+1;i++){
        //     for(int j =0;j<n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int ans = 0;
        for(int i =0;i<n;i++){
            ans = Math.max(ans,dp[k][i]);
        }
        return ans;
    }
}
public class CustomMaxMap<K> {
        private Map<K, Integer> map = new HashMap<>();
        private TreeMap<Integer, Set<K>> valueMap = new TreeMap<>();

        // Increment value or add new key
        public void putOrIncrement(K key) {
            int newValue = map.getOrDefault(key, 0) + 1;

            // Remove from old value set
            if (map.containsKey(key)) {
                int oldValue = map.get(key);
                Set<K> oldSet = valueMap.get(oldValue);
                oldSet.remove(key);
                if (oldSet.isEmpty()) valueMap.remove(oldValue);
            }

            // Update both maps
            map.put(key, newValue);
            valueMap.computeIfAbsent(newValue, k -> new HashSet<>()).add(key);
        }

        // Decrease value or remove if value is 1
        public void decrementOrRemove(K key) {
            if (!map.containsKey(key)) return;

            int oldValue = map.get(key);
            Set<K> oldSet = valueMap.get(oldValue);
            oldSet.remove(key);
            if (oldSet.isEmpty()) valueMap.remove(oldValue);

            if (oldValue == 1) {
                map.remove(key); // Remove entirely
            } else {
                int newValue = oldValue - 1;
                map.put(key, newValue);
                valueMap.computeIfAbsent(newValue, k -> new HashSet<>()).add(key);
            }
        }

        // Return any key with the maximum value
        public K getMaxKey() {
            if (valueMap.isEmpty()) return null;
            return valueMap.lastEntry().getValue().iterator().next();
        }

        // Optional: Get current value of a key
        public int getValue(K key) {
            return map.getOrDefault(key, 0);
        }

        public int getMaxValue(){
            return getValue(getMaxKey());
        }
    }
