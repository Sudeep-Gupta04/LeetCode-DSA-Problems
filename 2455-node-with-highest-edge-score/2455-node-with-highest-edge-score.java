class Solution {
    public int edgeScore(int[] edges) {
        long[] arr = new long[edges.length];
        for(int i =0;i<edges.length;i++){
            int score = i;
            int num = edges[i];
            arr[num] = arr[num]+i;
        }
        long ans = -1;
        int idx = -1;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]>ans){
                ans = arr[i];
                idx = i;
            } 
        }
        return idx;
    }
}