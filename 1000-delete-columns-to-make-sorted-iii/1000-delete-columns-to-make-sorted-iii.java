class Solution {
     public int minDeletionSize(String[] strs) {
        int m = strs[0].length();
        int n = strs.length;
        int[] dp = new int[m];
        Arrays.fill(dp,1);
        for(int col = m-2;col>=0;col--){
            for(int prevcol = col+1;prevcol<m;prevcol++){
                if(prevcolisValid(col,prevcol,strs)){
                   // System.out.println(col+" "+prevcol+" V");
                    dp[col] = Math.max(dp[col],1 + dp[prevcol]);
                }else{
                   // System.out.println(col+" "+prevcol+" IV");
                }
            }
        }
        int ans = 0;
        for(int i:dp) ans = Math.max(ans,i);
        return m - ans;
    }

    public boolean prevcolisValid(int col, int prevcol, String[] strs){
        int n = strs.length;
        for(int i = 0;i<n;i++){
            if(strs[i].charAt(col)>strs[i].charAt(prevcol)) return false;
        }
        return true;
    }
}