class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] valid = new int[s.length()+2];
        valid[0]=-1; valid[n+1]=-1;
        Stack<Integer> st = new Stack<>();
        int i =0;
        while(i<n){
            char ch = s.charAt(i);
            if(ch=='('){
                st.push(i);
            }else{
                if(!st.isEmpty() && s.charAt(st.peek())=='(') st.pop();
                else valid[i+1]=-1;
            }
            i++;
        }
        while(!st.isEmpty()){
            valid[st.pop()+1]=-1;
        }
        int l =0; int r =0;
        int size = 0;
        while(r<n+2){
            if(valid[r]==0) r++;
            else l = (r++)+1;
            size = Math.max(size,r-l);
        }
        return (size==1)?0:size;
    }
}