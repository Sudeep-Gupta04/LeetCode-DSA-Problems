class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            String ch = s.charAt(i)+"";
            if(ch.equals("(")) st.push(ch+"");
            else {
                if(!st.isEmpty()){
                    if(st.peek().equals("(")){
                        st.pop();
                        int add =0;
                        if(!st.isEmpty() && !st.peek().equals("(")){
                                add = Integer.parseInt(st.pop()+"");
                                //st.pop();
                        }
                        st.push(add+1+"");
                        //st.push("1");
                    }else{
                        int num = Integer.parseInt(st.pop()+"");
                         System.out.println(num);
                        if(!st.isEmpty() &&!st.peek().equals("(")){
                            int num2 = Integer.parseInt(st.pop()+"");
                            st.push(num2+num+"");
                        }else{
                            st.pop();
                            int add =0;
                            if(!st.isEmpty() && !st.peek().equals("(")){
                                add = Integer.parseInt(st.pop()+"");
                                //st.pop();
                            }
                            st.push(add+(num*2)+"");
                        }
                    }
                }
            }
            System.out.println(st);
        }
        int sum =0;
        System.out.println(st);
        while(!st.isEmpty()){
            sum+=Integer.parseInt(st.pop());
        }
        return sum;
    }
}