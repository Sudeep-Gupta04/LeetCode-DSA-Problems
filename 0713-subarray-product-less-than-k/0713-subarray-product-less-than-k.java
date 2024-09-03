class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    int c = 0;
    int pro = 1;

    for (int i = 0; i < nums.length; i++) {
        pro = 1;

        for (int j = i; j < nums.length; j++) {
            pro *= nums[j];

            if (pro < k) {
                c++;
            } else {
                break;
            }
        }
    }

    return c;
    }

}