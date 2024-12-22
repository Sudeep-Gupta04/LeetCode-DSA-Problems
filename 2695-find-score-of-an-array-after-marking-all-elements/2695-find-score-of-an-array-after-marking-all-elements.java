class Solution {
    public long findScore(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>((key1, key2) -> {
            int valueCompare = map.get(key1).compareTo(map.get(key2)); 
            if (valueCompare == 0) {
                return key1.compareTo(key2); 
            }
            return valueCompare;
        });
        for(int i =0;i<nums.length;i++){
            map.put(i,nums[i]);
        }
        tm.putAll(map);
        long ans =0;
        while (tm.size()>1){
            Map.Entry<Integer,Integer> temp = tm.firstEntry();
            ans+=temp.getValue();
            int idx = temp.getKey();
            if(idx==0) {
                tm.remove(0);
                tm.remove(1);
            } else if (idx == nums.length-1) {
                tm.remove(nums.length-1);
                tm.remove(nums.length-2);
            }else{
                tm.remove(idx-1);
                tm.remove(idx);
                tm.remove(idx+1);
            }
        }
        if(tm.size()>=1) ans += tm.firstEntry().getValue();
        return ans;
    }
}