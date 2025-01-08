import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public long calculateScore(String s) {
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<>();
        long score = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char real = s.charAt(i);
            int ch = s.charAt(i);
            char rev = (char)(219 - ch); // Calculate the mirror character

            if (!hm.containsKey(rev)) {
                if (!hm.containsKey(real)) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    hm.put(real, temp);
                } else {
                    ArrayList<Integer> t2 = hm.get(real);
                    t2.add(i);
                    hm.put(real, t2);
                }
            } else {
                ArrayList<Integer> t2 = hm.get(rev);
                int j = t2.remove(t2.size() - 1); 
                score += Math.abs(i - j); 
                if (t2.isEmpty()) {
                    hm.remove(rev);
                }
            }
        }
        return score;
    }
}
