class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int length = firstLen+secondLen;
        int[][] dp = new int[nums.length][3];
        for(int i =0;i< dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i =1;i<nums.length;i++) nums[i] = nums[i-1] + nums[i];

        int ij =  findAns(0,2,nums,dp,firstLen,secondLen);
        for(int i =0;i< dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int ji = findAns(0,2,nums,dp,secondLen,firstLen);
        System.out.println(ij + " " + ji);
        return Math.max(ij,ji);
    }

    private int findAns(int i, int p, int[] nums, int[][] dp,int f, int s) {
        if(i>=nums.length) return 0;
        if(dp[i][p]!=-1) return dp[i][p];
        if(p==0) return 0;
        int pick = 0;
         if(p==2 && i+1>=f){
            if(i-f<0) pick = nums[i] + findAns(i+s,p-1,nums,dp,f,s);
            else pick = nums[i]-nums[i-f] + findAns(i+s,p-1,nums,dp,f,s);
        } else if (p==1) {
            pick = nums[i]-nums[i-s] + findAns(i+s,p-1,nums,dp,f,s);
        }
        int notp = findAns(i+1,p,nums,dp,f,s);
        return dp[i][p] = Math.max(pick,notp);
    }
}