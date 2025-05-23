class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26;
        HashMap<List,Long> hm = new HashMap<>();
        for(int i =0;i<original.length;i++){
            List<Character> l = new ArrayList<>(Arrays.asList(original[i],changed[i]));
            if(!hm.containsKey(l)){
                hm.put(l,(long)cost[i]);
            }else{
                if(hm.get(l)>cost[i]) hm.put(l, (long) cost[i]);
            }
        }
        // for (Map.Entry<List, Long> entry : hm.entrySet()) {
        //     List<Character> key = entry.getKey();
        //     Long value = entry.getValue();
        //     System.out.println("[" + key.get(0) + ", " + key.get(1) + "] -> " + value);
        // }
        long[][] dis = new long[26][26];
        for(int i =0;i<n;i++) Arrays.fill(dis[i],(int)1e9);

        for (Map.Entry<List, Long> i : hm.entrySet()) {
            List<Character> t = i.getKey();
            char ch = t.get(0); 
            char ch2 = t.get(1);
            int index = ch - 'a';
            int index2 = ch2 - 'a';
            dis[index][index2] = i.getValue();
        }
        for(int i =0;i<n;i++) dis[i][i] = 0;

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                for(int k =0;k<n;k++){
                    dis[j][k] = Math.min(dis[j][k],dis[j][i]+dis[i][k]);
                }
            }
        }
        // for(int i =0;i<26;i++){
        //     System.out.println(Arrays.toString(dis[i]));
        // }
        long ans =0;
        for(int i =0;i<target.length();i++){
            int org = source.charAt(i) - 97;
            int chang = target.charAt(i) - 97;
            if(dis[org][chang] >= 1e9) return -1;
            else ans += dis[org][chang];
        }
        return ans;
    }
}