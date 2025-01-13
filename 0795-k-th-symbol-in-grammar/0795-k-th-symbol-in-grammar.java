class Solution {
    public int kthGrammar(int n, int k) {
    int cur = 0;
    int s = 0;
    int e = 1 << (n - 1);

    for (int i = 0; i < n - 1; i++) {
        int mid = (s + e) / 2;
        if (k > mid) {
            cur ^= 1;
            s = mid;
        } else {
            e = mid;
        }
    }
    return cur;
}

}