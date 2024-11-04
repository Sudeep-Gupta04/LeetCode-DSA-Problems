class Solution {
   int c =0;
    public int smallestDivisor(int[] nums, int threshold) {
        c = Integer.MAX_VALUE;
        int minans = 1;
        int maxans = 999999;
        while(minans<=maxans){
            int mid = (maxans + minans)/2;
            if(isvalid(mid,nums,threshold)) maxans=mid-1;
            else minans = mid+1;
        }
        return minans;
    }

    private boolean isvalid(int mid,int[] arr,int thresold) {
        int sum =0;
        for(int i =0;i<arr.length;i++){
            sum +=  (int) Math.ceil((double) arr[i] / mid);
        }
        if(sum<=thresold){
            c = sum;
            return true;
        }
        else return false;
    }
}