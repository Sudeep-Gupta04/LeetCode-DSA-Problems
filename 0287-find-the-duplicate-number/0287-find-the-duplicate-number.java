class Solution {
    static int x;
    public int findDuplicate(int[] nums) {
         Map<Integer,Integer> mp = new HashMap<>();
         for(int i =0;i< nums.length;i++){
             if(!mp.containsKey(nums[i])){
                 mp.put(nums[i],1);
             }
             else {
                 mp.put(nums[i],mp.get(nums[i])+1);
             }
         }
       for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
           if(entry.getValue()>1){
                x = entry.getKey();
               break;
           }
       }
        return x;
    }
}