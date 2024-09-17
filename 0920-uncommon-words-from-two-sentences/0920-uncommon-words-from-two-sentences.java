class Solution {
    public static void main(String[] args) {
        System.out.println(String.join(", ", uncommonFromSentences("this is a test", "this is another test")));
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        HashMap<String, Integer> hs = new HashMap<>();

        for (String word : words1) {
            hs.put(word, hs.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < words2.length; i++) {
            hs.put(words2[i], hs.getOrDefault(words2[i], 0) + 1);
        }

        hs.values().removeIf(count -> count > 1);

        String[] ans = hs.keySet().toArray(new String[0]);

        return ans;
    }

}