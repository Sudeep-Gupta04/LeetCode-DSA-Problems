class Solution {
    public String compressedString(String word) {
      if(word.length()==1){
        return "1"+word;
      }
      //word = word+""+1;
      int i =1;
      int c =1;
      String ans ="";
      char temp = word.charAt(0);
      while(i<word.length()){
        if(word.charAt(i)!=temp){
            ans += c+""+temp;
            temp = word.charAt(i);
            c = 1;
        }
        else if(word.charAt(i)==temp && c==9){
           ans += c+""+temp;
           temp = word.charAt(i);
           c = 1; 
        }
        else{
            c++;
        }
        i++;
      }  
      return ans+c+""+temp;
    }
}