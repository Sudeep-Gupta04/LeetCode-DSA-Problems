class Solution {
        public static int[][] initializeArrayint(int rows, int cols, int value) {
        int[][] array = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(array[i], value);
        }
        return array;
    }

        public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[][] dp = initializeArrayint(coins.length,amount+1,-1);
        int ans = helperr(coins,coins.length-1,amount,dp);
        if(ans >=100000002) return -1;
        else{
            return ans;
        }
    }

    private int helperr(int[] coins, int i,int amount, int[][] dp) {
        if(i==0){
           if(amount % coins[i]==0) return amount / coins[i];
           else return  100000002;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];

        int T = 100000002;
        if(coins[i]<=amount) T = 1 + helperr(coins,i,amount-coins[i],dp);
        int NT = helperr(coins,i-1,amount,dp);
       
        return dp[i][amount]= Math.min(T,NT);

    }
}