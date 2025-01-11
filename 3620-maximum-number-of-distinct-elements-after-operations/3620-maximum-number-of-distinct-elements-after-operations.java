class Solution {
    // public int maxDistinctElements(int[] nums, int k) {
    //     int n = nums.length;
    //     Arrays.sort(nums);
    //     if(n<=3 && k!=0) return n;
    //     HashSet<Integer> hs = new HashSet<>();
    //     if(k==0){
    //         for(int i =0;i<nums.length;i++){
    //             hs.add(nums[i]);
    //         }
    //         return hs.size();
    //     }
    //     int s =0;int e =n-1;
    //     nums[s]=nums[s]-k;
    //     nums[e]=nums[e]+k;
    //     e--;s++;
        
    //      while((s<n) && (nums[s]-nums[s-1]>1)){
    //         if(nums[s]-nums[s-1]>k){
    //             nums[s]=nums[s]-k;
    //         }else {
    //             nums[s]=nums[s-1]+1;
    //         }
    //          s++;
    //      }
    //      System.out.println(s+" "+e);
    //      while(e>s){
    //         if(nums[e+1]==nums[e]){
    //             e--;
    //             continue;                       
    //         }
    //         else if(nums[e+1]-nums[e]>k){
    //             nums[e]=nums[e]+k;
    //         }else{
    //              nums[e]=nums[e+1]-1;
    //         }
    //         e--;
    //      }
    //     System.out.println(s+" "+e);
    //     if(e<s) return n;
    //     // while((e>=0)  && (nums[e+1]-nums[e]>1) && (e>=s)){
            
    //     //     e--;
    //     // }
    //     if(e<s) return n;
    //     else{
    //         for(int i =0;i<nums.length;i++){
    //             hs.add(nums[i]);
    //         }
    //         return hs.size();
    //         } 
    //     }
    int maxDistinctElements(int[] nums, int k) {
    int ans = 0;
    Arrays.sort(nums);
    for(int i = 0, last = Integer.MIN_VALUE; i < nums.length; ++i){
        int mn = nums[i] - k;
        int mx = nums[i] + k;
        if(last < mn ) { last = mn; ans++; }
        else if(last < mx){ last = last + 1; ans++; }
    }
    return ans;
}
    }