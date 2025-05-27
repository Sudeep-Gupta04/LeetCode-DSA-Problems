class Solution {
    public int maxSelectedElements(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer,Integer> hm = new HashMap<>();
       // hm.put(nums[0]+1,1);
       // hm.put(nums[0],1);
        hm.put(0,0);
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i =0;i<n;i++){
            int p1 = 1;
            if(hm.containsKey(nums[i])) {
                p1 += hm.get(nums[i]);
            }
            hm.put(nums[i]+1,p1);
            int p2 = 1;
            if(hm.containsKey(nums[i]-1)) {
                p2 += hm.get(nums[i]-1);
            }
            hm.put(nums[i],p2);
            int p3 =0;
            if(i!=0) p3 = dp[i-1];
            dp[i] = Math.max(p1,Math.max(p3,p2));

            
            //System.out.println(hm);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
    // public int helper(int i, int[] nums,int[][] dp,int con){
    //     if(i<0) return 0;
    //     if(dp[i][con+1]!=-1) return dp[i][con+1];
    //     // 3 pick condition
    //     int upd =0;
    //     int pick = 0;
    //     int leave = 0;
    //     if(con==-1){
    //         upd = 1+ helper(i-1,nums,dp,0);
    //         pick = 1+helper(i-1,nums,dp,1);
    //         leave = helper(i-1,nums,dp,-1);
    //     }else if(con==0){
    //         int lastpick = nums[i+1]+1;
    //         if(nums[i]+1+1==lastpick) upd = 1+helper(i-1,nums,dp,1);
    //         if(nums[i]+1==lastpick) pick = 1+helper(i-1,nums,dp,0);
    //         leave = helper(i-1,nums,dp,con);
    //     }else {
    //         int lastpick = nums[i+1];
    //         if(nums[i]+1+1==lastpick) upd = 1+helper(i-1,nums,dp,1);
    //         if(nums[i]+1==lastpick) pick = 1+helper(i-1,nums,dp,0);
    //         leave = helper(i-1,nums,dp,con);
    //     }
    //     return dp[i][con+1] = Math.max(upd,Math.max(pick,leave));
    // }
}