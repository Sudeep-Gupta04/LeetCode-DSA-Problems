class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i =n-1;i>=0;i--){
            if(!st.isEmpty()){
                while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i]=0;
                    st.push(i);
                    continue;
                }
                ans[i] = st.peek()-i;
                st.push(i);
            }else{
                ans[i]=0;
                st.push(i);
            }
        }
        return ans;
    }
}