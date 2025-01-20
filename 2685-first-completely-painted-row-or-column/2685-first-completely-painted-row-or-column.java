class Solution {
  public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer,int[]> hm = new HashMap<>();
        for(int i =0;i<mat.length;i++){
            for(int j =0;j<mat[0].length;j++) {
                hm.put(mat[i][j], new int[]{i,j});
            }
        }
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        int r = mat.length;
        int c = mat[0].length;
        
        for(int i =0;i<arr.length;i++){
            int num = arr[i];
            int[]xy = hm.get(num);
            rows[xy[0]]++;
            cols[xy[1]]++;
            if(rows[xy[0]]>=c || cols[xy[1]]>=r) return i;
        }
        return 0;
    }
}