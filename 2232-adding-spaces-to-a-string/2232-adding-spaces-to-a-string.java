class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder ans = new StringBuilder();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (k < spaces.length && i == spaces[k]) {
                ans.append(' '); // Add a space
                k++;
            }
            ans.append(s.charAt(i)); // Add the current character
        }
        return ans.toString();
    }
}
