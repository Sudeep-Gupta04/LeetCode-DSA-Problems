
    class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> al = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            if(i%2!=0){
                for(int j = grid[0].length-1;j>=0;j--){
                    if (j % 2 != 0) al.add(grid[i][j]);
                }  
            }else{
                for (int j = 0; j < grid[0].length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) al.add(grid[i][j]);
                    } 
                 }
            }
        }
        return al;
    }
}

