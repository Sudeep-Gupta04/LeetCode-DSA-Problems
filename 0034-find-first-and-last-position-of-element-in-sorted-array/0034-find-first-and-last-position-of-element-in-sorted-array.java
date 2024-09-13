class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx =  lowerBound(nums,target,0,nums.length-1);
        if(idx== nums.length-1 || nums[idx+1]!=target) return new int[] {-1,-1};
        int uidx = upperBound(nums,target,0,nums.length-1);
        if(uidx==-1) return new int[]{idx+1,0};
        else return new int[]{idx+1,uidx-1};
    }

    private int upperBound(int[] nums, int target, int s, int e) {
        while(s<=e){
            int mid = (s+e)/2;
            if(target<nums[mid]) e = mid-1;
            else s = mid+1;
        }
        return s;
    }

    private int lowerBound(int[] nums, int target, int s, int e) {
        while(s<=e){
            int mid = (s+e)/2;
            if(target<=nums[mid]) e = mid-1;
            else s = mid+1;
        }
        return e;
    }
}