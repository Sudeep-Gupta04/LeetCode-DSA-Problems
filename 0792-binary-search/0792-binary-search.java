class Solution {
    public int search(int[] nums, int target) {
        int s =0;
        int e= nums.length;
        while(s<=e){
            int mid = (s+e)/2;
            if(mid>=nums.length || mid<0) break;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) e = mid -1;
            else s = mid+1;
        }
        return -1;
    }
}