class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str2.length()>str1.length()) return false;
        int p2 = 0;int p1 = 0;
        while(p2<str2.length()  && p1<str1.length()){
            int ascii = str1.charAt(p1);
            int ascii2 = str2.charAt(p2);
            if(ascii==ascii2 || ascii+1==ascii2  || (ascii==122 && ascii2==97)){
                p2++;
            }
            p1++;
        }
        if(p2>=str2.length()) return true;
        else return false;
    }
}