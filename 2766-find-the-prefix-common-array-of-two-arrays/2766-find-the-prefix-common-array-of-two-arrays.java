class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
    int c = 0;
    int[] arr = new int[A.length];
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
        if (hm.containsKey(A[i])) {
            c++;
        } else {
            hm.put(A[i], 1);
        }
        if (hm.containsKey(B[i])) {
            c++;
        } else {
            hm.put(B[i], 1);
        }
        arr[i] = c;
    }
    return arr;
    }
}