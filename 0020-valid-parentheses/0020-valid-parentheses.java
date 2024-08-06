class Solution {
    public boolean isValid(String s) {
     Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(st.size()==0 && (s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']')){
                return false;
            }
            if((s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')){
                st.push(s.charAt(i));
            }
            else {
                char x = st.peek();
                if((s.charAt(i)==']' && x=='[')||(s.charAt(i)=='}' && x=='{')||(s.charAt(i)==')' && x=='(')){
                    st.pop();
                }
                else return false;
            }
        }
        if(!st.isEmpty()){
            return false;
        }
        return true;   
    }
}