class Solution {
    public List<List<String>> partition(String s) {
     List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        helper(result, s, temp);
        return result;
    }
    private void helper(List<List<String>> result, String s, List<String> temp) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(temp));  // Create a copy of temp before adding
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            int start = 0;
            int end = i;
            if (isPalindrom(s.substring(start, end + 1))) {
                temp.add(s.substring(start, end + 1));
                helper(result, s.substring(end + 1), temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    boolean isPalindrom(String s) {
        StringBuilder str = new StringBuilder(s);
        return s.equals(str.reverse().toString());
    }
}