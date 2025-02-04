class Solution {
     public List<String> generateParenthesis(int n) {
        Stack<Character> st = new Stack<>();
        List<String> ans = new ArrayList<>();
        compute(ans,n,n,st,"");
        return ans;
    }
    public void compute(List<String> ans,int o,int c,Stack<Character> st,String cur){
        if(o==0 && c==0){
            ans.add(cur);
            return;
        }
        if(st.isEmpty() && o !=0){
            st.push('(');
            compute(ans,o-1,c,st,cur+'(');
            if(!st.isEmpty())st.pop();
        } 
        else if(o!=0){
            st.push('(');
            compute(ans,o-1,c,st,cur+'(');
            if(!st.isEmpty())st.pop();
        }
        if(!st.isEmpty() && c!=0 && o<c){

            st.push(')');
            compute(ans,o,c-1,st,cur+')');
            if(!st.isEmpty())st.pop();
        }
    }
}