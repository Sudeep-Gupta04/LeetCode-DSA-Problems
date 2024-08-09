class MinStack {
        class Node{
            int val;
            Node next;
            
            public Node(int val) {
                this.val = val;
            }
        }

        Node head;
        Stack<Integer> st;
        public MinStack() {
           
           st = new Stack<>();
        }

        public void push(int val) {
            if(head==null){
                head = new Node(val);
                st.push(val);
            }
            else {
                if(val<=head.val){
                    Node node = new Node(val);
                    node.next = head;
                    head = node;
                }
                st.push(val);
            }
        }

        public void pop() {
        if (st.peek() == head.val) {
            head = head.next;
        }
        st.pop();
    }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return head.val;
        }
    }
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */