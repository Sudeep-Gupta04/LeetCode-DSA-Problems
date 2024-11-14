class Solution {
    int sum = 0;

   public int minimizedMaximum(int n, int[] quantities) {
        int start = 1;
        int end =Integer.MIN_VALUE;

        for(int i =0;i<quantities.length;i++){
            end = Integer.max(end,quantities[i]);
            sum+=quantities[i];
        }
        while(start<=end){
          int mid = (start+end)/2;
          int c = check(quantities,n,mid);
          if(c==0) start = mid+1;
          else end = mid-1;
        }
        return start;
    }

    private int check(int[] quantities, int n,int x) {
//        int[] temp = Arrays.copyOf(quantities,quantities.length);
//        int s = sum;
//        if((double) (sum/x) > (double) n) return 0;
//        int i = 1;
//        int k = 0;
//        int ans =0;
//        while(i!=n && k != quantities.length){
//            if(temp[k]<= x){
//                ans += quantities[k];
//                i++;
//                k++;
//            }
//            else {
//                temp[k] = quantities[k]-x;
//                ans+=x;
//                i++;
//            }
//        }
//        if((ans==s && i!=n) || (i==n && ans==s)) return 1;
//        if(ans!=s && i==n) return 2;
        int count = 0;
        for(int i =0;i<quantities.length;i++){
            count+= (int) Math.ceil((double) quantities[i] /x);
        }
        if(count>n) return 0;
        else return 1;
    }

}