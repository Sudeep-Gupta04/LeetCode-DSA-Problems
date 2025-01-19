class Solution {
   public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        HashMap<Integer,Integer> mp = new HashMap<>();
        int ans =0;
        mp.put(ages[0],1);
        for(int i =1;i<ages.length;i++){
            mp.put(ages[i],mp.getOrDefault(ages[i],0)+1);
            int idx = find(ages,0,i-1,ages[i]);
            ans += (i-idx);
        }
        for(Map.Entry<Integer,Integer> i: mp.entrySet()){
            System.out.println(i.getKey() + " " + i.getValue());
            if(i.getKey()>14 && i.getValue()>1){
                int val = i.getValue()-1;
                ans+=(val*(val+1))/2;
            }
        }
        return ans;
    }
    public int find(int[] ages,int s,int e,int tar){
        while(s<=e){
            int mid = (s+e)/2;
            if(ages[mid] > (tar/2.0)+7) e = mid -1;
            else s = mid+1;
        }
        return s;
    }
}