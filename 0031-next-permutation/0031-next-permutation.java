
public class Solution {
    private int findTarget(int l, int r, int target, int[] nums) {
        int ans = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public void nextPermutation(int[] nums) {
        int idx = -1;
        // Step 1: Find the first decreasing element from the end
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                idx = i;
                break;
            }
        }

        // Step 2: If no such element is found, the array is in descending order
        if (idx == -1) {
            Arrays.sort(nums);
            return;
        }

        // Step 3: Find the smallest element greater than nums[idx] to the right of idx
        int swapIndex = findTarget(idx, nums.length-1, nums[idx-1], nums);

        // Step 4: Swap the elements at idx and swapIndex
        int temp = nums[idx-1];
        nums[idx-1] = nums[swapIndex];
        nums[swapIndex] = temp;

        // Step 5: Sort the subarray from idx + 1 to the end of the array
        Arrays.sort(nums, idx, nums.length);
    }

}
