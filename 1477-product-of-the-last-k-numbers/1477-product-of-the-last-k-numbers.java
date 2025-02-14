class ProductOfNumbers {
    long[] arr;
    static int idx;
    static int zero;

    public ProductOfNumbers() {
        arr = new long[(int)1e5]; // Cast 10e4 to int correctly
        idx = 0;
        zero = -1;
    }
    
    public void add(int num) {
        if (num != 0) {
            if (idx == 0) arr[idx] = num;
            else arr[idx] = arr[idx - 1] * num;
        } else {
            arr[idx] = 1;
            zero = idx;
        }
        idx++;
    }
    
    public int getProduct(int k) {
        int s = idx - k - 1;
        if (zero > s) return 0;
        if(s>=0) return (int) (arr[idx - 1] / arr[s]);
        else return (int) arr[idx-1];
    }
}
