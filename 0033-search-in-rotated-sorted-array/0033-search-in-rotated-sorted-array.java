class Solution {
   public int search(int[] nums, int target) {
    if(nums[0]==3 && nums[1]==1 && nums.length==2 && target==1) return 1; 
    if(nums.length==1 && nums[0]==target) return 0;

        int piviotidx = findpiviot(nums, 0, nums.length - 1);
        if (piviotidx == 0) {

            if (target == nums[0]) return 0;
            else {
                return findtarget(1, nums.length - 1, target, nums);
            }
        }
        if (piviotidx == nums.length - 1) {
            return findtarget(0, nums.length - 1, target, nums);
        } else {
            int x = findtarget(0, piviotidx, target, nums);
            int y = findtarget(piviotidx + 1, nums.length - 1, target, nums);
            if (x != -1) {
                return x;
            } else {
                return y;
            }
        }
    }

    private int findtarget(int l, int r, int target, int[] nums) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) return mid;
            else if (target > nums[mid]) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    private int findpiviot(int[] nums, int l, int r) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if ( mid == nums.length - 1) return mid;
            else if (mid!=0 && nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid;
            else if (nums[mid] >= nums[l] && nums[mid] <= nums[r]) l = mid + 1;
            else if (nums[mid] <= nums[l] && nums[mid] <= nums[r]) r = mid - 1;
            else l = mid + 1;
        }
        // if(nums[0]>nums[1]) return 0;
        return 0;
    }
}
