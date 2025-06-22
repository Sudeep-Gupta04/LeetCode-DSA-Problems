class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int[] arr = new int[n];
        return helper(0,arr,requests);
    }

    private int helper(int i, int[] arr, int[][] requests) {
        if(i>=requests.length){
            for(int num:arr) if(num!=0) return -9999999;
            return 0;
        }
        
        int from = requests[i][0]; int to = requests[i][1];
        // take 
        arr[from] -= 1; arr[to] += 1;
        int take = 1 + helper(i+1,arr,requests);
        arr[from] += 1; arr[to] -= 1;
        //ntake
        int ntake = helper(i+1,arr,requests);
        
        
        return Math.max(take,ntake);
        
    }
}