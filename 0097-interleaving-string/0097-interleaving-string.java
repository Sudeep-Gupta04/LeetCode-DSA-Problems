import java.util.HashMap;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s1.length() + s2.length() != s3.length()) return false;
        HashMap<String, Boolean> memo = new HashMap<>();
        return check(0, 0, s1, s2, s3, memo, "");
    }

    public boolean check(int i, int j, String s1, String s2, String s3, HashMap<String, Boolean> memo, String c) {
        if (i == s1.length() && j == s2.length()) {
            return s3.equals(c);
        }
        String key = i + "," + j;
        if (memo.containsKey(key)) return memo.get(key);

        boolean p1 = false, p2 = false;

         if(i<s1.length() && s1.charAt(i) == s3.charAt(i + j)) p1 = check(i+1,j,s1,s2,s3,memo,c+s1.charAt(i));
         if(j<s2.length() && s2.charAt(j) == s3.charAt(i + j)) p2 = check(i,j+1,s1,s2,s3,memo,c+s2.charAt(j));

        // Store result in memoization map
        boolean result = p1 || p2;
        memo.put(key, result);
        return result;
    }
}
