class Solution {
    HashMap<Integer,HashSet<String>> hm;
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        hm = new HashMap<>();
        for(int i =0;i<n;i++){
            HashSet<String> hs = new HashSet<>();
            for(int j = 0;j<words[i].length();j++){
                String result = new StringBuilder(words[i]).replace(j, j+1, "X").toString();
                hs.add(result);
            }
            hm.put(i,hs);
        }
        int[] path = new int[n];
        int[] dp = new int[n];
        for(int i =0;i<n;i++) path[i] = i;
        Arrays.fill(dp,1);
        int max = 1;
        int maxidx = 0;
        for(int i =1;i<n;i++){
            for(int j = i-1;j>=0;j--){
                if(isValid(i,j,words,groups) && dp[i]<=1+dp[j]){
                    path[i] = j;
                    dp[i] = 1 + dp[j];
                }
            }
            if(dp[i]>max){
                max = dp[i];
                maxidx = i;
            }
        }
        ArrayList<String> al = new ArrayList<>();
        int i = maxidx;
        //System.out.println(Arrays.toString(path));
        while(path[i]!=i){
            al.add(words[i]);
            i = path[i];
        }
        al.add(words[i]);
        Collections.reverse(al);
        return al;
    }

    private boolean isValid(int i, int j, String[] words, int[] groups) {
        boolean p1 = (groups[i]!=groups[j]);
        boolean p2 = false;
        HashSet<String> hs = hm.get(j);
        for(int k = 0;k<words[i].length();k++){
            String result = new StringBuilder(words[i]).replace(k, k+1, "X").toString();
            if(hs.contains(result)) p2 = true;
        }
        return (p1 && p2);
    }
}