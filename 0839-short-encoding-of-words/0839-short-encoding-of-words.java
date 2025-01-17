class Solution {
    public int minimumLengthEncoding(String[] words) {
        int n = words.length;
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder s = new StringBuilder(words[i]);
            al.add(s.reverse().toString());
        }
        Collections.sort(al);
        
        int i = 0;
        while (i < al.size() - 1) {
            if (al.get(i + 1).startsWith(al.get(i))) {
                al.remove(i);
            } else {
                i++;
            }
        }

        int ans = 0;
        for (String word : al) {
            ans += (word.length() + 1);
        }
        return ans;
    }
}
