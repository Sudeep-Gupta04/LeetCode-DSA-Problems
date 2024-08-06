class Solution {
     public int numDecodings(String s) {
        int n = s.length();
        HashMap<String,Integer> mp = new HashMap<>();

        //return Decording(s,mp);

        int[] dp = new int[s.length()];
        if(s.charAt(s.length()-1)=='0') dp[s.length()-1]=0;
        else dp[s.length()-1]=1;

        for(int i = s.length()-2;i>=0;i--){
            if(s.charAt(i)=='0') dp[i] =0;

            else if (Integer.parseInt(s.substring(i,i+2))<=26) {
                if(i+2 < s.length()) dp[i]= dp[i+1]+dp[i+2];
                else if (i+2==s.length()) dp[i] = dp[i+1]+1;
                else dp[i] = dp[i+1];
            }

            else {
                dp[i]=dp[i+1];
            }
        }
        return dp[0];
    }

    private int Decording( String s, HashMap<String, Integer> mp) {
        if (Objects.equals(s, "")) return 1;

        String key = s;
        if (mp.containsKey(s)) return mp.get(s);

        int sngtake = 0;
        if (s.charAt(0) != '0') sngtake = Decording(s.substring( 1), mp);

        int dubtake = 0;
        if (s.charAt(0) != '0' && s.length()>1) {
            int val = Integer.parseInt(s.substring(0,2) + "");
            if (val <= 26) dubtake = Decording( s.substring(2), mp);
        }
        int ans = sngtake + dubtake;
        mp.put(key, ans);
        return ans;
    }
}