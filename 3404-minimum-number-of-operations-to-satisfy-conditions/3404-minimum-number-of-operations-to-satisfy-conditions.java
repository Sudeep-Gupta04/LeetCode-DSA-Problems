class Solution {
    int[][] dp;
    HashMap<Integer,HashMap> hm;
    public int minimumOperations(int[][] grid) {
        hm = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;
        dp = new int[m][11];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        for(int j =0;j<m;j++){
            HashMap<Integer,Integer> freq = new HashMap<>();
            for(int i =0;i<n;i++){
                freq.put(grid[i][j],freq.getOrDefault(grid[i][j],0)+1);
            }
            hm.put(j,freq);
        }

        return helper(0,-1,grid,m);
    }

    private int helper(int j, int prev, int[][] grid,int m) {
        if(j>=m) return 0;
        if(dp[j][prev+1]!=-1) return dp[j][prev+1];
        
        int ans = Integer.MAX_VALUE;
        for(int num = 0;num<=9;num++){
            int freq = (hm.get(j).get(num)==null?0:(int) hm.get(j).get(num));
            int cost = grid.length - freq;
            if(prev!=num){
                ans = Math.min(ans, cost + helper(j+1,num,grid,m));
            }
        }
        return dp[j][prev+1] = ans;
    }
}
