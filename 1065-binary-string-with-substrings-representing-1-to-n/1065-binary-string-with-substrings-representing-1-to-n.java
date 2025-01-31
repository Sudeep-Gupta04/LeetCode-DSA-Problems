class Solution {
    public boolean queryString(String S, int N) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < S.length(); i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = i; j < S.length(); j++) {
                sb.append(S.charAt(j));
                
                if (sb.length() > 1 && sb.charAt(0) == '0') {
                    continue;
                }
                
                int v = Integer.parseInt(sb.toString(), 2);
                
                if (v > 0 && v <= N) {
                    set.add(v);
                }
                
                if (v > N) {
                    break;
                }
            }
        }
        
        return set.size() == N;
    }
}
