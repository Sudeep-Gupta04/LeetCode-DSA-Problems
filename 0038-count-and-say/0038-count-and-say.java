class Solution {
    public String countAndSay(int n) {
        return helper(n);
    }

    private String helper(int n) {
        if (n == 1) return "1";
        String ans = helper(n - 1);
        String compute = "";
        int[] temp = new int[2];
        for (int i = 0; i < ans.length(); i++) {
            int x1 = Integer.parseInt(ans.charAt(i) + "");
            if (i + 1 < ans.length() && x1 == Integer.parseInt(ans.charAt(i + 1) + "")) {
                temp[0]++;
            } else {
                temp[1] = x1;
                temp[0]++;
                compute += temp[0] + "" + temp[1];
                temp = new int[2];
            }
        }
        return compute;
    }
}
