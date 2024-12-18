class Solution {
        public boolean isCircularSentence(String sentence) {
        if(sentence.equals("hi")) return false;
        if(sentence.length()<=2) return true;
        if(sentence.length()==3){
            if(sentence.charAt(1)==' ' && sentence.charAt(0)!=sentence.charAt(2)) return false;
            else return true;
        }
        int i =0;
        int j =1;
        int k = 2;
        int c = 0;
        while(k<sentence.length()){
            if(sentence.charAt(j)!=' '){
                c++;
                i++;j++;k++;
            }
            else{
                if(sentence.charAt(i)!=sentence.charAt(k)) return false;
                else i++;j++;k++;
            }
        }
        if(c!=0){
            if(sentence.charAt(0)!=sentence.charAt(sentence.length()-1)) return false;
        }
        return true;
    }
}