class Solution {
    public String clearDigits(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            int asci = (int)s.charAt(i);
            if((asci>=97 && asci<=122) || st.isEmpty()){
                st.add(s.charAt(i));
            }
            else{
                if(!st.isEmpty()){
                    int asci2 = (int)st.peek();
                    if(asci2>=97 && asci2<=122) st.pop();
                    else st.add(s.charAt(i));
                }else st.add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder("");
        while(!st.isEmpty()){
            sb = sb.append(st.pop());
            
        }
        return sb.reverse().toString();
    }
}