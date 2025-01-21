class Solution {
    
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        if (n == 1) return 0;

        long[] up = new long[n];
        long[] down = new long[n];

        up[n - 1] = grid[0][n - 1];
        down[0] = grid[1][0];

        for (int i = 1; i < n; i++) {
            down[i] = down[i - 1] + grid[1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            up[i] = up[i + 1] + grid[0][i];
        }

        long pa = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long d = (i == 0) ? 0 : down[i - 1];
            long u = (i == n - 1) ? 0 : up[i + 1];
            long ans = Math.max(d, u);
            pa = Math.min(ans, pa);
        }

        return pa;
    
}

    // up[n-1] = grid[0][n-1]+grid[1][n-1];
        // down[n-1] = up[n-1];
        // for(int i =n-2;i>=0;i--){
        //     up[i]=grid[0][i]+up[i+1];
        //     down[i]=(down[i+1]-grid[0][i+1])+grid[0][i]+grid[1][i];
        // }
        // System.out.println(Arrays.toString(up));
        // System.out.println(Arrays.toString(down));
        // int cidx =-1;
        // for(int i =0;i<n;i++){
        //     if(down[i]>up[i]){
        //         cidx=i;
        //         break;
        //     }
        // }
        // System.out.println(cidx);
        // if(cidx==-1){
        //     int sum =0;
        //     for(int i =0;i<n-1;i++){
        //         sum+=grid[1][i];
        //     }
        //     return sum;
        // }else{
        //     int sum =0;
        //     for(int i =0;i<cidx;i++){
        //         sum+=grid[1][i];
        //     }
        //     int sum1= 0;
        //     for(int i =cidx+1;i<n;i++){
        //         sum1+=grid[0][i];
        //     }
        //     return Math.max(sum,sum1);
        // }
        //;
        //return 0;
}