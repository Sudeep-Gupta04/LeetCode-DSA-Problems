class Solution {
     public int minimumDeletions(int[] nums) {
        if(nums.length==1) return 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minidx = 0;
        int maxidx = 0;
        for(int i =0;i< nums.length;i++){
            if(nums[i]<min){
                min = nums[i];
                minidx = i;
            }
            if(nums[i]>max){
                max = nums[i];
                maxidx = i;
            }
        }
        if(minidx < maxidx){                   // min    max
            int p1 = maxidx + 1;
            int p2 = nums.length - minidx;
            int p3 = minidx + 1 + (nums.length-maxidx);
            return Math.min(p1,Math.min(p2,p3));

        }else {                      // max      min
            int p1 = minidx + 1;
            int p2 = nums.length - maxidx;
            int p3 = maxidx + 1 + (nums.length - minidx);
            return Math.min(p1,Math.min(p2,p3));
        }
    }
}