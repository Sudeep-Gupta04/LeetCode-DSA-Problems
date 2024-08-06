class Solution {
    int count = 0;
    public int countSubstrings(String s) {

        for(int i =0;i<s.length();i++){
            countPalandrome(s,i,i);
        }
        for(int i =0;i<s.length()-1;i++){
            countPalandrome(s,i,i+1);
        }
        return count;
    }

    private void countPalandrome(String s, int L, int R) {
        while (L>=0 && R<s.length()){
            if(s.charAt(L)==s.charAt(R)){
                count++;
                L--;
                R++;
            }else{
                break;
            }
        }
    }
}