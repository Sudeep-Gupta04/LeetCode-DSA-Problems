class Solution {
    int[][] dp;
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        System.out.println(Arrays.toString(words));
        dp = new int[n][n+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        return helper(0,-1,words);
    }
    public int helper(int i,int prv, String[] words){
        if(i>=words.length) return 0;
        if(dp[i][prv+1]!=-1) return dp[i][prv+1];
        int tk =0; int ntk = 0;
        if(prv==-1){
            tk = 1 + helper(i+1,i,words);
        }else{
            if(isValid(words[prv],words[i])) tk = 1 + helper(i+1,i,words);
        }
        ntk = helper(i+1,prv,words);
        return dp[i][prv+1] = Math.max(tk,ntk);
    }
    public boolean isValid(String s1, String s2){
        if(s2.length()-s1.length()!=1) return false;
        int i = 0;int j =0;
        while(i<s2.length() && j<s1.length()){
            if(s2.charAt(i)==s1.charAt(j)){
                i++;j++;
            }
            else i++;
        }
        return (j==s1.length());
    }
}