class StockSpanner {
    Stack<Integer> st;
    ArrayList<Integer> al;
    int idx = -1;
    public StockSpanner() {
        st = new Stack<>();
        al = new ArrayList<>();
    }

    public int next(int price) {
        idx++;
        al.add(price);
        while(!st.isEmpty() && al.get(st.peek()) <= price){
            st.pop();
        }
        int ans;
        if(!st.isEmpty()) ans = idx - st.peek();
        else ans = idx+1;

        st.push(idx);
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */