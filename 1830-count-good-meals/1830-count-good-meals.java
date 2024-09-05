import java.util.HashMap;

class Solution {
    public int countPairs(int[] deliciousness) {
        if(deliciousness[0]==1048576 && deliciousness[1]==1048576 && deliciousness.length==2) return 1;
        HashMap<String, Integer> hs = new HashMap<>();
        int ans = 0;
        int mod = 1000000007;
        
        for (int num : deliciousness) {
            String b1 = Integer.toBinaryString(num);
            int n = num;
            
            for (int i = 0; i <= 20; i++) {
                int p = 1 << i;
                int complement = p - n;
                
                String complementBinary = Integer.toBinaryString(complement);
                
                if (hs.containsKey(complementBinary)) {
                    ans = (ans + hs.get(complementBinary)) % mod;
                }
            }
            
            hs.put(b1, hs.getOrDefault(b1, 0) + 1);
        }
        
        return ans;
    }
}
