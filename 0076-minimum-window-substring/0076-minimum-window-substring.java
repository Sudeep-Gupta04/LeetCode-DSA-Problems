class Solution {
    private boolean isWindowValid(Map<Character, Integer> mp, Map<Character, Integer> finalMap) {
        for(char ch: finalMap.keySet()) {
            if(!mp.containsKey(ch) || mp.get(ch) < finalMap.get(ch)) return false;
        }

        return true;        
    }

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m < n) return "";

        Map<Character, Integer> mp = new HashMap<>();
        Map<Character, Integer> finalMap = new HashMap<>();

        for(int i=0;i<n;i++) {
            char ch = t.charAt(i);
            finalMap.put(ch, finalMap.getOrDefault(ch, 0) + 1);
        }

        int i = 0; int j = 0; 
        int min = m+1; String str = "";

        while(j <= m) {
            if(j == m) break; 

            char ch = s.charAt(j);

            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            if(j-i+1 >= finalMap.size()) {
                while(i <= j && isWindowValid(mp, finalMap)) {
                    int len = j-i+1;

                    if(len < min) {
                        min = len;
                        str = s.substring(i, j+1);
                    }

                    char temp = s.charAt(i);
                    mp.put(temp, mp.getOrDefault(temp, 0) - 1);
                    if(mp.get(temp) == 0) mp.remove(temp);

                    i++;
                }
            }

            j++;
        }

        return min <= m ? str : "";
    }
}