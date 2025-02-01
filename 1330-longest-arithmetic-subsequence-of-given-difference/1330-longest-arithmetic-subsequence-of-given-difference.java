class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int d = difference;
        int ans = 0;
        for(int i =0;i<arr.length;i++){
            if(mp.containsKey(arr[i]-d)){
                mp.put(arr[i],mp.get(arr[i]-d) +1 );
            }else{
                mp.put(arr[i],1);
            }
            ans = Math.max(ans,mp.get(arr[i])+1);
        }
        return ans-1;
    }
}