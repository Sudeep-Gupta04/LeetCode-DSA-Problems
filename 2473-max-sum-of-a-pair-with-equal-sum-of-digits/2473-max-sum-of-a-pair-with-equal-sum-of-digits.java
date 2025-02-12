class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max = 0;

        for(int i =0;i<nums.length;i++){
            int num = nums[i];
            int sod = 0;
            while(num!=0){
                sod+=(num%10);
                num/=10;
            }
            if(hm.containsKey(sod)){
                int psum = hm.get(sod);
                max = Math.max(max,psum+nums[i]);
                if(nums[i]>psum){
                    hm.put(sod,nums[i]);
                }
            }else{
                hm.put(sod,nums[i]);
            }
        }

        return (max==0)?-1:max;
    }
}