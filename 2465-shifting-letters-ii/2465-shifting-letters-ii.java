class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diff = new int[s.length()];  
        for (int i = 0; i < shifts.length; i++) {
            if (shifts[i][2] == 1) {
                diff[shifts[i][0]] += 1;
                if (shifts[i][1] + 1 < s.length()) {
                    diff[shifts[i][1] + 1] -= 1;
                }
            } else {
                diff[shifts[i][0]] += -1;
                if (shifts[i][1] + 1 < s.length()) {
                    diff[shifts[i][1] + 1] += 1;
                }
            }
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int sft = (diff[i] % 26 + 26) % 26;
            char newch = (char) ('a' + (s.charAt(i) - 'a' + sft) % 26); 
            sb.append(newch);
        }
        return sb.toString();
    }
}
