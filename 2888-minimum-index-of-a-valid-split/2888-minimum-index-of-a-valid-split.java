class Solution {
   public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i =0;i<nums.size();i++){
            hm.put(nums.get(i), hm.getOrDefault(nums.get(i), 0) + 1);
        }
        int num = 0;
        int count = 0;
        for(Map.Entry<Integer,Integer> i:hm.entrySet()){
            if(i.getValue()>nums.size()/2){
                count = i.getValue();
                num = i.getKey();
                break;
            }
        }
        System.out.println(num+" "+count);
        int lc = 0;
        for(int i =0;i<nums.size();i++){
            if(nums.get(i)==num) {
                lc+=1;
                count-=1;
                if(lc>(i+1)/2 && ((nums.size()-i-1)/2<count)) return i; 
            }
        }
        return -1;
    }
}