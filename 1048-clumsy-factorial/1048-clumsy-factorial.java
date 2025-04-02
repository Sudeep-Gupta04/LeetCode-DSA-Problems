class Solution {
    public int clumsy(int n) {
        Stack<Integer> num = new Stack<>();
        Stack<Character> st = new Stack<>();
        int c = 4;

        for (int i = n; i >= 1; i--) {
            num.push(i);
            if (i != 1) {
                if (c == 4) {
                    st.push('*');
                    c = 2;
                } else if (c == 2) {
                    // Immediately compute * and /
                    while (!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')) {
                        int num1 = num.pop();
                        char ch = st.pop();
                        int num2 = num.pop();
                        num.push((ch == '/') ? (num2 / num1) : (num2 * num1));
                    }
                    st.push('/');
                    c = 1;
                } else if (c == 1) {
                    while (!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')) {
                        int num1 = num.pop();
                        char ch = st.pop();
                        int num2 = num.pop();
                        num.push((ch == '/') ? (num2 / num1) : (num2 * num1));
                    }
                    st.push('+');
                    c = 3;
                } else if (c == 3) {
                    while (!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')) {
                        int num1 = num.pop();
                        char ch = st.pop();
                        int num2 = num.pop();
                        num.push((ch == '/') ? (num2 / num1) : (num2 * num1));
                    }
                    st.push('-');
                    c = 4;
                }
            }
        }
        return evaluateExpression(num,st);
    }
      public  int evaluateExpression(Stack<Integer> numStack, Stack<Character> opStack) {
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();

        // Transfer Stack contents to Lists (Reverse order for correct computation)
        while (!numStack.isEmpty()) {
            numbers.add(0, numStack.pop()); 
        }
        while (!opStack.isEmpty()) {
            operators.add(0, opStack.pop()); 
        }
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '*') {
                int result = numbers.get(i) * numbers.get(i + 1);
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--;
            } else if (operators.get(i) == '/') {
                int result = numbers.get(i) / numbers.get(i + 1);
                numbers.set(i, result);
                numbers.remove(i + 1);
                operators.remove(i);
                i--; // Adjust index after removal
            }
        }
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '+') {
                result += numbers.get(i + 1);
            } else if (operators.get(i) == '-') {
                result -= numbers.get(i + 1);
            }
        }

        return result;
    }
}
