class Solution {
    int[][] dp;
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        dp = new int[n][3];
        for(int[] i:dp) Arrays.fill(i,-1);
        int[] nxtgre = new int[nums.length];
        int[] nxtsme = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i =n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()) nxtgre[i] = st.peek();
            else nxtgre[i] = -1;
            st.push(i);
        }
        st.clear();
        for(int i =n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()) nxtsme[i] = st.peek();
            else nxtsme[i] = -1;
            st.push(i);
        }

        return helper(0,-1,nxtgre,nxtsme,nums)+1;
    }
    // 0 for previous was + and 1 means previous wwas negative
    public int helper(int i, int pre,int[] nxtgre, int[] nxtsme,int[] nums){
        if(i>=nums.length) return 0;
        if(dp[i][pre+1]!=-1) return dp[i][pre+1];

        if(pre==-1){
            int takep = 0;int taken = 0;
            if(nxtgre[i]!=-1)  takep = 1 + helper(nxtgre[i],0,nxtgre,nxtsme,nums);
            if(nxtsme[i]!=-1)  taken = 1 + helper(nxtsme[i],1,nxtgre,nxtsme,nums);

            int ntake = helper(i+1,pre,nxtgre,nxtsme,nums);

            return dp[i][pre+1] = Math.max(ntake,Math.max(takep,taken));
        }else{
            int take = 0;
            if(pre==0 && nxtsme[i]!=-1) take = 1 + helper(nxtsme[i],1,nxtgre,nxtsme,nums);
            else if(pre==1 && nxtgre[i]!=-1) take = 1 + helper(nxtgre[i],0,nxtgre,nxtsme,nums);

            int ntake = helper(i+1,pre,nxtgre,nxtsme,nums);
            return dp[i][pre+1] = Math.max(ntake,take);
        }
    }
}