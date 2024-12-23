class Solution {
   static public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] pre = new int[nums.length];
        pre[0] = 0;
        for(int i =1;i<nums.length;i++){
            if(Math.abs(nums[i]-nums[i-1])%2==0){
                pre[i]=1+pre[i-1];
            }else{
                pre[i]=pre[i-1];
            }
        }
        boolean ans[] = new boolean[queries.length];
        for(int i =0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start==end) ans[i]= true;
            else if(end-start==1) {
                if(Math.abs(nums[end]-nums[start])%2!=0) ans[i]= true;
            }else{
               if(pre[end]==pre[start]) ans[i]=true;
            }
        }
        return ans;
    }
}
