class Solution {
    Pair[][] dp;
    public boolean predictTheWinner(int[] nums) {
        dp = new Pair[nums.length][nums.length];
        Pair p = helper(0,nums.length-1,nums,nums.length);
        return (p.x>=p.y);
    }

    private Pair helper(int i, int j, int[] nums,int n) {
        if(i==j) return new Pair(nums[i],0);
        if(j-i==1) return new Pair(Math.max(nums[j],nums[i]),Math.min(nums[j],nums[i]));
        if(dp[i][j]!=null) return dp[i][j];
        int leftp1 = nums[i] + helper(i+1,j,nums,n).y;
        int rightp1 = nums[j] + helper(i,j-1,nums,n).y;
        int leftp2 = helper(i+1,j,nums,n).x;
        int rightp2 = helper(i,j-1,nums,n).x;

        if(leftp1>=rightp1){
            return dp[i][j] = new Pair(leftp1,leftp2);
        }else{
            return dp[i][j] = new Pair(rightp1,rightp2);
        }
    }

    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
