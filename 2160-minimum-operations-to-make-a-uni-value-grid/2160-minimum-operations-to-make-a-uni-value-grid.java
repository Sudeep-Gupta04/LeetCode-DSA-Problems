class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] arr = new int[grid.length*grid[0].length];
        int k =0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                arr[k++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int mid = arr[arr.length/2];
        int c = 0;
        for(int i =0;i<arr.length;i++){
            if(Math.abs(mid-arr[i])%x!=0) return -1;
            else{
                c+=(Math.abs(mid-arr[i])/x);
            }
        }
        return c;
    }
}