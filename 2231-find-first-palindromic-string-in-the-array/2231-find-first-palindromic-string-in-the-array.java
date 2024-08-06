class Solution {
    public static String firstPalindrome(String[] words) {
        String p = "";
        for(int i = 0; i < words.length; i++) {
            boolean ans = check(words[i]);
            if (ans) {
                 p = words[i];
                 break;
            }
        }
        return p; 
    }

    public static boolean check(String a){
        StringBuffer sb = new StringBuffer(a);
        return a.equals(sb.reverse().toString());
    }
}