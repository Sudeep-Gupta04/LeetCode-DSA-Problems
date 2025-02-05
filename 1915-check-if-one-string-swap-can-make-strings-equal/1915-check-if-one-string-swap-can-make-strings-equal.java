class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int c =0;
        char[] ch1 = new char[2];
        char[] ch2 = new char[2];
        for(int i =0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(c==2) return false;
                ch1[c]=s1.charAt(i);
                ch2[c]=s2.charAt(i);
                c++;
            }
        }
        if(c==1) return false;
        Arrays.sort(ch1);Arrays.sort(ch2);
        if(ch1[0]!=ch2[0] || ch1[1]!=ch2[1]) return false;
        return true;
    }
}