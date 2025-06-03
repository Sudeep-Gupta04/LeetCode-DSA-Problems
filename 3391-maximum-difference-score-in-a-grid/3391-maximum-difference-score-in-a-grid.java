class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] dp = new int[n][m];
        int ans = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i==0 && j==0) continue;
                int mini = Integer.MAX_VALUE;
                int minj = Integer.MAX_VALUE;
                if(i>0) mini = grid.get(i-1).get(j);
                if(j>0) minj = grid.get(i).get(j-1);
                int min = Math.min(mini,minj);
                ans = Math.max(ans,grid.get(i).get(j)-min);
                grid.get(i).set(j,Math.min(min,grid.get(i).get(j)));
            }
        }
        return ans;
    }
}