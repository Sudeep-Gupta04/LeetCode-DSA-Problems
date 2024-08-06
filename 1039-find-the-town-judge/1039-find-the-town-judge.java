import java.util.HashMap;
import java.util.Map;
import java.util.List;

class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> trusteeCount = new HashMap<>(); // Maps person to the count of people trusting them
        Map<Integer, Integer> trustorCount = new HashMap<>(); // Maps person to the count of people they trust

        if (trust.length == 0 && n == 1)
            return 1;
        else if (trust.length == 0 && n > 1)
            return -1;

        for (int i = 0; i < trust.length; i++) {
            int trustor = trust[i][0];
            int trustee = trust[i][1];
            trusteeCount.put(trustee, trusteeCount.getOrDefault(trustee, 0) + 1);
            trustorCount.put(trustor, trustorCount.getOrDefault(trustor, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : trusteeCount.entrySet()) {
            int person = entry.getKey();
            int trustCount = entry.getValue();
            if (trustCount == n - 1 && !trustorCount.containsKey(person)) {
                return person;
            }
        }

        return -1;
    }
}
