class Solution {
        public static String reverseParentheses(String s) {
       Stack<String> st = new Stack<>();

       for(int i =0;i<s.length();i++){
           if(s.charAt(i)==')'){
               String str ="";
               while (!Objects.equals(st.peek(), '(' + "")){
                   if(st.peek().length()>1){
                       StringBuilder sb = new StringBuilder(st.peek());
                       sb = sb.reverse();
                       str = str+sb;
                   }else {
                       str = str+st.peek();
                   }
                   st.pop();
               }
               st.pop();
               st.push(str);
           }else {
               st.push(s.charAt(i)+"");
           }
       }
       if(st.size()==1) return st.peek();
       else{
           String[] arr = new String[st.size()];
           int k = st.size()-1;
           while (!st.isEmpty()){
               arr[k--] = st.pop();
           }
           String ans ="";
           for(int i =0;i<arr.length;i++){
               ans+=arr[i];
           }
           return ans;
       }
    }
}