class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k!=0) return false;
        HashMap<Integer,Integer> tm= new HashMap<>();
        Arrays.sort(nums);
        for(int i =0;i<nums.length;i++){
            tm.put(nums[i],tm.getOrDefault(nums[i],0)+1);
        }
        for(int i =0;i<nums.length;i++){
            int num = nums[i];
            if(tm.containsKey(num)){
                for(int j =0;j<k;j++){
                    if(!tm.containsKey(num)) return false;
                    else{
                        if(tm.get(num)>1) tm.put(num,tm.get(num)-1);
                        else tm.remove(num);
                    }
                    num++;
                }
            }
        }
        if(!tm.isEmpty()) return false;
        return true;

    }
}