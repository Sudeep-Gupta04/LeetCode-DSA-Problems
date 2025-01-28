class Solution {
    public int[] prevPermOpt1(int[] arr) {
    Stack<Integer> st = new Stack<>();
    int[] nexg = new int[arr.length];
    int[] maxArray = {0};

    for (int i = 0; i < arr.length; i++) {
        while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
            st.pop();
        }
        nexg[i] = st.isEmpty() ? -1 : st.peek();
        st.push(i);
    }

    for (int i = arr.length - 1; i > 0; i--) {
        if (arr[i] == arr[i - 1]) continue;

        int idx = nexg[i];
        if (idx < i && idx >= 0) {
            int[] temp = arr.clone();
            int num = temp[i];
            temp[i] = temp[idx];
            temp[idx] = num;

            if (isGreater(maxArray, temp)) {
                maxArray = temp;
            }
        }
    }
    if(maxArray.length==1) return arr;
    return maxArray;
}

private boolean isGreater(int[] arr1, int[] arr2) {
    for (int i = 0; i < arr1.length; i++) {
        if (arr1[i] != arr2[i]) {
            return arr1[i] < arr2[i];
        }
    }
    return false;
}


}