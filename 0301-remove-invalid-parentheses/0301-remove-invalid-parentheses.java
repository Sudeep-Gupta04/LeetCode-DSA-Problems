class Solution {
    private HashSet<String> hs = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int[] invalidCount = countInvalidParentheses(s);
        helper(s, 0, invalidCount[0], invalidCount[1]);
        return new ArrayList<>(hs);
    }

    // Step 1: Calculate the number of invalid parentheses
    private int[] countInvalidParentheses(String s) {
        int leftInvalid = 0, rightInvalid = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftInvalid++;
            } else if (ch == ')') {
                if (leftInvalid > 0) {
                    leftInvalid--;
                } else {
                    rightInvalid++;
                }
            }
        }
        return new int[]{leftInvalid, rightInvalid};
    }

    // Step 2: Recursively generate valid sequences by removing invalid parentheses
    private void helper(String s, int index, int leftToRemove, int rightToRemove) {
        if (leftToRemove == 0 && rightToRemove == 0) {
            if (checkIsValid(s)) {
                hs.add(s);
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // Avoid duplicate removals
            if (i != index && s.charAt(i) == s.charAt(i - 1)) continue;

            // Remove a left parenthesis if necessary
            if (leftToRemove > 0 && s.charAt(i) == '(') {
                helper(s.substring(0, i) + s.substring(i + 1), i, leftToRemove - 1, rightToRemove);
            }
            // Remove a right parenthesis if necessary
            if (rightToRemove > 0 && s.charAt(i) == ')') {
                helper(s.substring(0, i) + s.substring(i + 1), i, leftToRemove, rightToRemove - 1);
            }
        }
    }

    // Check if the current string is valid
    private boolean checkIsValid(String s) {
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
                if (balance < 0) return false;
            }
        }
        return balance == 0;
    }
}
