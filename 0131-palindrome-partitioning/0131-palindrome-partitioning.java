import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(result, s, 0, temp, new StringBuilder());
        return result;
    }

    private void helper(List<List<String>> result, String s, int start, List<String> temp, StringBuilder current) {
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));  // Create a copy of temp before adding
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            current.append(s.charAt(i));
            if (isPalindrom(current)) {
                temp.add(current.toString());
                helper(result, s, i + 1, temp, new StringBuilder());  // Pass a new StringBuilder for the next recursion level
                temp.remove(temp.size() - 1);
            }
           // current.deleteCharAt(current.length() - 1);  // Backtrack
        }
    }

    private boolean isPalindrom(StringBuilder sb) {
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left++) != sb.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
