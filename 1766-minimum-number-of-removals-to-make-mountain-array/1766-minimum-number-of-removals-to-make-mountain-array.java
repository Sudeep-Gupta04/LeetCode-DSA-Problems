class Solution {
    public static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] inc = new int[n];
        inc[0] = 1;
        List<Integer> al = new ArrayList<>();
        al.add(nums[0]);
        for(int i =1;i<n;i++){
            if(al.getLast()<nums[i]) {
                al.add(nums[i]);
                inc[i] = al.size();
            }
            else{
                int idx = Collections.binarySearch(al,nums[i]);
                if(idx<0) idx = -(idx+1);
                al.set(idx,nums[i]);
                inc[i] = idx+1;
            }
        }
        al.clear();
        al.add(nums[n-1]);
        int[] dec = new int[n];
        dec[n-1] = 1;
        for(int i =n-2;i>=0;i--){
            if(al.getLast()<nums[i]) {
                al.add(nums[i]);
                dec[i] = al.size();
            }
            else{
                int idx = Collections.binarySearch(al,nums[i]);
                if(idx<0) idx = -(idx+1);
                al.set(idx,nums[i]);
                dec[i] = idx+1;
            }
        }
       
        int ans = 0;
        for(int i =1;i<n-1;i++){
            if(inc[i]==1 || dec[i]==1) continue;
            ans = Math.max(ans,inc[i]+dec[i]-1);
        }
        return n-ans;
    }
}