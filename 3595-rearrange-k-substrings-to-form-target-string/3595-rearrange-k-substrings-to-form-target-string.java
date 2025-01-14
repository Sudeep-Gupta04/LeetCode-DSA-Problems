public class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        if (k <= 0 || k > Math.min(s.length(), t.length())) {
            return false;
        }
        k = t.length()/k;
        ArrayList<String> al = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= t.length() - k; i+=k) {
            String sub = t.substring(i, i + k);
            al.add(sub);
        }
        for (String i : al) {
            char[] charArray = i.toCharArray();
            Arrays.sort(charArray);
            String st = i;
            map.put(st, map.getOrDefault(st, 0) + 1);
        }
        System.out.println(al);
        al.clear();

        for (int i = 0; i <= s.length() - k; i+=k) {
            String sub = s.substring(i, i + k);
            al.add(sub);
        }

        for (String i : al) {
            char[] charArray = i.toCharArray();
            Arrays.sort(charArray);
            String st = i;
            if (!map.containsKey(st)) {
                return false;
            } else {
                if (map.get(st) > 1) {
                    map.put(st, map.get(st) - 1);
                } else {
                    map.remove(st);
                }
            }
        }

        return true;
    }
}
