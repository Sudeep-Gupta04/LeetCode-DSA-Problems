class Solution {
public String makeFancyString(String s) {
    if (s.length() == 1) return s;

    char temp = s.charAt(0);
    StringBuffer ans = new StringBuffer();
    ans.append(temp);
    int c = 1;

    for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) == temp) {
            c++;
            if (c < 3) ans.append(s.charAt(i));
        } else {
            c = 1;
            temp = s.charAt(i);
            ans.append(temp);
        }
    }
    return ans.toString();
    }
}