class Solution {
    HashMap<Integer,HashMap<Character,Integer>> hm;
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        hm = new HashMap<>();
        dp = new int[strs.length][m+1][n+1];
        for(int[][] i:dp){
            for(int [] j:i){
                Arrays.fill(j,-1);
            }
        }
        for(int i = 0;i<strs.length;i++){
            StringBuilder str = new StringBuilder(strs[i]);
            HashMap<Character,Integer> freq = new HashMap<>();
            for(int j =0;j<str.length();j++){
                char ch = str.charAt(j);
                freq.put(ch,freq.getOrDefault(ch,0)+1);
            }
            hm.put(i,freq);
        }
        return helper(0,m,n,strs);
    }
    public int helper(int i, int zeros, int ones, String[] str){
        if(i>=str.length) return 0;
        if(dp[i][zeros][ones]!=-1) return dp[i][zeros][ones];
        int take = Integer.MIN_VALUE;
        int c0 = hm.get(i).getOrDefault('0', 0);
        int c1 = hm.get(i).getOrDefault('1', 0);
        if(zeros>=c0 && ones>=c1) take = 1 + helper(i+1,zeros-c0,ones-c1,str);
        int ntake = helper(i+1,zeros,ones,str);
        return dp[i][zeros][ones] = Math.max(take,ntake);
    }
}