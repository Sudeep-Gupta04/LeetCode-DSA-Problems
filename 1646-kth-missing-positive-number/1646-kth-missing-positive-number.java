class Solution {
     public int findKthPositive(int[] arr, int k) {
        if (arr.length==1){
           if(arr[0]>k) return k;
           else{
               int rem =  k - (arr[0]-(0+1));
               return rem + arr[0];
           }
        }
        if(arr[0]>k){
            return k;
        }
        int minmiss=0;
        int min = 0;
        int s =0;
        int e = arr.length-1;
        while(s<=e){
            int mid = (s+e)/2;
            int miss = arr[mid] - (mid+1);
            if(miss>=minmiss && miss<k){
                min = mid;
                minmiss = miss;
            }
            if(miss>=k) {
                e=mid-1;
            }
            else s = mid+1;
        }
        int rem =  k - (arr[min]-(min+1));
        return rem + arr[min];
    }
}