class Solution {
     public int maxProfit(int[] prices) {
        int buy = prices[0];
        int pro = 0;
        for(int i =1;i<prices.length;i++){
            if(prices[i]>buy){
                pro = Math.max(pro,prices[i]-buy);
            }else buy = prices[i];
        }
        return pro;
    }
}