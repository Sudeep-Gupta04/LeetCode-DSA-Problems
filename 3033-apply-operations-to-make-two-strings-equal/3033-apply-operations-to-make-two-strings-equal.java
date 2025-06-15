class Solution {
    int x;
    Integer[][][] dp;
    public int minOperations(String s1, String s2, int x) {
        dp = new Integer[s1.length()][2][2];
        this.x = x;
        int ans = helper(0,0,0,s1,s2);
        return (ans>=9999999)?-1:ans;
    }


    public int helper(int i, int isrevesed, int power,String s1,String s2){
        if(i==s2.length()-1) {
            char curr = ((isrevesed==1)? (char) (s1.charAt(i)^1) :s1.charAt(i));
            if((curr!=s2.charAt(i) && power==1) || (curr==s2.charAt(i) && power==0)) return 0;
            return 9999999;
        }
        if(dp[i][isrevesed][power]!=null) return dp[i][isrevesed][power];
        int ans = 9999999;
        char curr = ((isrevesed==1)? (char) (s1.charAt(i)^1) :s1.charAt(i));
        if(curr==s2.charAt(i)) ans = helper(i+1,0,power,s1,s2);
        else{ // 2 possiblilty reverse wiht the i+1 index or take x and leave it for geetitng reverse in future with power 1;
            if(power==1){
                ans = Math.min(ans,Math.min(1 + helper(i+1,1,1,s1,s2),helper(i+1,0,0,s1,s2)));
            }else{
                ans = Math.min(ans , Math.min(1 + helper(i+1,1,0,s1,s2), x + helper(i+1,0,1,s1,s2)));
            }
        }

        return dp[i][isrevesed][power] = ans;
    }
}