class Solution {
    Pair[][] dp;
    int[] sump;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        dp = new Pair[stones.length][stones.length];

        this.sump = new int[n];
        sump[0] = stones[0];
        for(int i =1;i<n;i++) sump[i] = stones[i] + sump[i-1];


        Pair p = helper(0,stones.length-1,stones,stones.length);
        return (p.x-p.y);
    }
    private Pair helper(int i, int j, int[] nums, int n) {
    if(i==j) return new Pair(0,0);
    if (dp[i][j] != null) return dp[i][j];

    int total = (i == 0) ? sump[j] : sump[j] - sump[i - 1];
    
    Pair left  =  helper(i+1,j,nums,n);
    int leftsc = total - nums[i];
    Pair op1 = new Pair(leftsc+left.y,left.x);

    Pair right  =  helper(i, j-1, nums, n);
    int rightsc = total - nums[j];
    Pair op2 = new Pair(rightsc+right.y,right.x);

    
    if(op1.x-op1.y>=op2.x-op2.y) return dp[i][j] = op1;
    else return dp[i][j] = op2;
    }


    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
