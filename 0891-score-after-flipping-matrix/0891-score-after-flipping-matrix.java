class Solution {
    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            StringBuilder org = new StringBuilder();
            StringBuilder zor = new StringBuilder();

            for (int j = 0; j < grid[0].length; j++) {
                org.append(grid[i][j]);
                zor.append(grid[i][j]^1);
            }

            if(Integer.parseInt(zor.toString(),2)>Integer.parseInt(org.toString(),2)) {
                for (int j = 0; j < grid[0].length; j++) {
                    grid[i][j] = grid[i][j] ^ 1;
                }
            }
        }

        for(int i =0;i<grid.length;i++){
            System.out.println(Arrays.toString(grid[i]));
        }


        for(int j =grid[0].length-1;j>0;j--){
            int sum = 0;
            int zorsum =0;
            for(int i =0;i<grid.length;i++){
                StringBuilder org = new StringBuilder();
                StringBuilder zor = new StringBuilder();
                for(int k =j;k<grid[0].length;k++){
                    if(k==j) zor.append(grid[i][k]^1);
                    else zor.append(grid[i][k]);

                    org.append(grid[i][k]);
                }
                sum+=Integer.parseInt(org.toString(),2);
                zorsum += Integer.parseInt(zor.toString(),2);
            }
            if(zorsum>sum){
                for(int k =0;k<grid.length;k++){
                    grid[k][j]=grid[k][j]^1;
                }
            }
        }
        int ans =0;
        for (int i = 0; i < grid.length; i++) {
            StringBuilder org = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                org.append(grid[i][j]);
            }
            ans += Integer.parseInt(org.toString(),2);
        }
        return ans;
    }
}