class Solution {
   public boolean rotateString(String s, String goal) {
        if(goal.length()!=s.length()) return false;
        char c = goal.charAt(0);
        for(int i =0;i<goal.length();i++){
            if(s.charAt(i)==c){
                String temp = s.substring(i) + s.substring(0,i);
                if(temp.equals(goal)) return true;
            }
        }
        return false;
    }
}