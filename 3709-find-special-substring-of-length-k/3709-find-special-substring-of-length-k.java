class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        char pre=s.charAt(0);
        int count=1;
        for(int i=1;i<s.length();i++){
            char curr=s.charAt(i);
            if(pre==curr){
                count++;
            }
            else{
                if(count==k){
                    return true;
                }
                else{
                    count=1;
                }
            }
            pre=curr;
        }
        if(count==k){
            return true;
        }
        return false;
    }
}