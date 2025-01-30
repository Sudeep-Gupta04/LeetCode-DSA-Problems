class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        //int mxi=0;
        int mx = values[0];
        int n = values.length;
        // for(int i =1;i<n-1;i++){
        //     //System.out.println(i+values[i]);
        //     if(i+values[i]>=mx){
        //         mx = i+values[i];
        //         mxi =i;
        //     }
        // }
        // System.out.println(mxi);
        // int mxj =1;
        // mx = values[1] -1;
        int ans = 0;
        for(int i =1;i<n;i++){
            System.out.println(values[i] - i);
            
            ans = Math.max(ans,mx+values[i] - i);
            mx = Math.max(values[i] + i,mx);
        }
        //System.out.println(mxj);
        return ans;
    }
}