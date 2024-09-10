class Solution {
     public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(longtrstsubArray(answerKey,k,'T','F'),longtrstsubArray(answerKey,k,'F','T'));
    }
    public int longtrstsubArray(String s , int k , Character val,Character change){
        int l = 0;
        int r = 0;
        int count =0;
        int length = 0;
        while(r<s.length()){
            char ch = s.charAt(r);
            if(ch==change){
                count++;
            }
            if(count>k){
                if(s.charAt(l)==change){
                    count = count-1;
                }
                l++;
            }
            if(count<=k){
                length = Math.max(length,r-l+1);
            }
            r++;
        }
        return length;
    }
}