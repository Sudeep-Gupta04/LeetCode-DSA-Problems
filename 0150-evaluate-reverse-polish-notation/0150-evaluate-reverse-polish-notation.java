class Solution {
    public int evalRPN(String[] tokens) {
      Stack<Long> st = new Stack<>();
    
    for (int i = 0; i < tokens.length; i++) {
        String token = tokens[i];
        
        
        if (token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
            Long top = st.pop();
            Long below = st.pop();
            char operator = token.charAt(0);
            
            if (operator == '+') {
                st.push(below + top);
            } else if (operator == '-') {
                st.push(below - top);
            } else if (operator == '*') {
                st.push(below * top);
            } else {
                st.push(below / top);
            }
        } else {
            
            st.push(Long.parseLong(token));
        }
    }
    
    return Math.toIntExact(st.peek());   
    }
}