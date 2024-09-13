class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     int min = 1;
     int max = 0;
     for(int i =0;i<piles.length;i++ ){
         max=Math.max(piles[i],max);
     }
     
     while(min<=max){
         int mid = (min+max)/2;
         if(isvlaid(mid,h,piles)){
             max = mid-1;
         }else {
             min = mid+1;
         }
     }
     return min;
    }

    private boolean isvlaid(int mid, int h, int[] piles) {
        int ans = 0;
        for(int i =0;i<piles.length;i++){
            ans+= (piles[i]+mid-1)/mid;
            if(ans>h) return false;
        }
        return true;
    }
}