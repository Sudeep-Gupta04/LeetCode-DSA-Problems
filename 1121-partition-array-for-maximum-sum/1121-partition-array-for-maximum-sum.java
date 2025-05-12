class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return solve(arr.length,k,arr);
    }
    public int solve(int N, int k, int arr[]) {

    int[] pre = new int[N];
    pre[N-1] = arr[N-1];
  
    for (int i = N-2; i >= 0; i--) {
        int c = 1;
        int pa = pre[i + 1] + arr[i];
        int tm = arr[i];

        for (int j = i; j < Math.min(i + k, N); j++) {
            tm = Math.max(tm, arr[j]);
            int suffix;
            if(j+1>=N) suffix = 0;
            else suffix = pre[j+1];
            pa = Math.max(pa, c * tm + suffix);
            c++;
        }

        pre[i] = pa;
    }
    System.out.println(Arrays.toString(pre));
    return pre[0];
}

}