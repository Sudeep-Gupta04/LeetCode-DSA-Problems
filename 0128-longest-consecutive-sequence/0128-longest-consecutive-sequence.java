class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        HashSet<Integer> mp = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            mp.add(nums[i]);
        }
        int mans =1;
        for(int i:mp){
            int ans = 1;
            if(!mp.contains(i-1)){
                while(mp.contains(i+1)){
                    ans++;
                    i++;
                }
            }
            mans = Math.max(ans,mans);
        }
        return mans;
    }
}