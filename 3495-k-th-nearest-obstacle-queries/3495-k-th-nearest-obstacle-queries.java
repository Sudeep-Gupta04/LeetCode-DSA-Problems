class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int [] arr = new int[queries.length];
        for(int i =0;i<queries.length;i++){
            if(i<k) {
                arr[i]=-1;
            }
            int num = Math.abs(queries[i][0])+Math.abs(queries[i][1]);
            pq.add(num);
            if(pq.size()==k) arr[i]=pq.peek();
            if(pq.size()>k){
                pq.remove();
                arr[i]=pq.peek();
            }
        }
        return arr;
    }
}