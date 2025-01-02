class Solution {
    public String compressedString(String word) {
        if (word.length() == 1) {
            return "1" + word; // Handle single-character case
        }

        int i = 1;
        int c = 1;
        StringBuilder ans = new StringBuilder(); // Use StringBuilder for efficiency
        char temp = word.charAt(0);

        while (i < word.length()) {
            if (word.charAt(i) != temp) {
                ans.append(c).append(temp); // Append count and character
                temp = word.charAt(i);
                c = 1; // Reset count
            } else if (word.charAt(i) == temp && c == 9) {
                ans.append(c).append(temp); // Append when count reaches 9
                temp = word.charAt(i);
                c = 1; // Reset count
            } else {
                c++; // Increment count
            }
            i++;
        }

        // Append the last segment
        ans.append(c).append(temp);

        return ans.toString(); // Convert StringBuilder to String
    }
}