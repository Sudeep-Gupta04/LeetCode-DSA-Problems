class Solution {
    int dp[][];
    public int maxHeight(int[][] cuboids) {
        dp = new int[cuboids.length][cuboids.length];
        for(int[] i:dp) Arrays.fill(i,-1);
        for(int[] i:cuboids) Arrays.sort(i);
        Arrays.sort(cuboids,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[1]*o2[2] == o1[1]*o1[2]) return o2[0]-o1[0];
                return o2[1]*o2[2] - o1[1]*o1[2];
            }
        });
        for(int[] i:cuboids) System.out.println(Arrays.toString(i));
        return helper(0,-1,cuboids);
    }

    private int helper(int i, int pre, int[][] cuboids) {
        if(i>=cuboids.length) return 0;
        if(dp[i][pre+1]!=-1) return dp[i][pre+1];
        if(pre==-1){
            int take = cuboids[i][2] + helper(i+1,i,cuboids);
            int ntake = helper(i+1,pre,cuboids);
            return dp[i][pre+1] = Math.max(take,ntake);
        }else{
            int take = 0;
            if(cuboids[i][0] <= cuboids[pre][0] && cuboids[i][1] <= cuboids[pre][1] && cuboids[i][2] <= cuboids[pre][2]){
                take = cuboids[i][2] + helper(i+1,i,cuboids);
            }
            int ntake = helper(i+1,pre,cuboids);
            return dp[i][pre+1] = Math.max(take,ntake);
        }
    }
}