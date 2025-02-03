class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //if(s1.length()>s2.length()) return false;
        
        char[] sh1 = s1.toCharArray();
        Arrays.sort(sh1);
        String temp = new String(sh1);
        int k = s1.length();
        for(int i =0;i<=s2.length()-k;i++){
            String sb = s2.substring(i,i+k);
            char[] ch = sb.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if(str.equals(temp)) return true;
        }
        return false;
    }
}
//   a b c e s e r
//   0 1 2 3 4 5 6