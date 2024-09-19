
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        HashMap<String, List<Integer>> hs = new HashMap<>();
        return helpme(hs, expression);
    }

    private int evaluateExpression(String expression) {
        int result = 0;
        char operator = ' ';
        int currentNumber = 0;
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            } else {
                if (operator != ' ') {
                    result = applyOperator(result, operator, currentNumber);
                } else {
                    result = currentNumber;
                }
                operator = c;
                currentNumber = 0;
            }
        }
        result = applyOperator(result, operator, currentNumber);
        return result;
    }

    private int applyOperator(int left, char operator, int right) {
        if (operator == '+') return left + right;
        if (operator == '-') return left - right;
        if (operator == '*') return left * right;
        if (operator == '/') return left / right;
        return 0;
    }

    private List<Integer> helpme(HashMap<String, List<Integer>> hs, String expression) {
        if (expression.isEmpty()) return new ArrayList<>();
        
        if (hs.containsKey(expression)) {
            return new ArrayList<>(hs.get(expression));
        }

        List<Integer> result = new ArrayList<>();
        
        if (expression.chars().allMatch(Character::isDigit)) {
            result.add(Integer.parseInt(expression));
            hs.put(expression, result);
            return result;
        }

        List<Integer> operators = new ArrayList<>();
        for (int q = 0; q < expression.length(); q++) {
            if (expression.charAt(q) == '*' || expression.charAt(q) == '/' || expression.charAt(q) == '+' || expression.charAt(q) == '-') {
                operators.add(q);
            }
        }

        for (int operatorIndex : operators) {
            char operator = expression.charAt(operatorIndex);
            String leftPart = expression.substring(0, operatorIndex);
            String rightPart = expression.substring(operatorIndex + 1);

            List<Integer> leftResults = helpme(hs, leftPart);
            List<Integer> rightResults = helpme(hs, rightPart);

            for (int left : leftResults) {
                for (int right : rightResults) {
                    result.add(applyOperator(left, operator, right));
                }
            }
        }

        hs.put(expression, result);
        return result;
    }

    private int count(String expression) {
        int c = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                c++;
            }
        }
        return c;
    }
}
