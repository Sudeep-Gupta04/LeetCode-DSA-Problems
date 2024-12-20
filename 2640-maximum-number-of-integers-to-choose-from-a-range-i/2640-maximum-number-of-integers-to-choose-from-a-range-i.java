
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
    HashSet<Integer> hs = new HashSet<>();
    for (int i = 0; i < banned.length; i++) {
        hs.add(banned[i]);
    }
    int sum = 0, c = 0, i = 1;
    while (i <= n) {
        if (!hs.contains(i)) {
            sum += i;
            if (sum > maxSum) return c;
            c++;
        }
        i++;
    }
    return c;
}

}
