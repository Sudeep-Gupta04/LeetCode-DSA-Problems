class Solution {
    public int search(int[] nums, int target) {
        int pivotIdx = findPivot(nums, 0, nums.length - 1);
        
        if (nums[pivotIdx] == target) {
            return pivotIdx;
        }
        
        if (pivotIdx == 0 || pivotIdx == nums.length - 1) {
            return findTarget(0, nums.length - 1, target, nums);
        }
        
        if (target >= nums[0]) {
            return findTarget(0, pivotIdx - 1, target, nums);
        } else {
            return findTarget(pivotIdx + 1, nums.length - 1, target, nums);
        }
    }

    private int findTarget(int l, int r, int target, int[] nums) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private int findPivot(int[] nums, int l, int r) {
        if (nums[l] < nums[r]) {
            return 0; // Array is not rotated
        }
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            
            if (mid < r && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (mid > l && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return 0;
    }
}
