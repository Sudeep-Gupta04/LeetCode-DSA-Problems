class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = max;
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            
            // We need to calculate the potential new max and min values before updating them.
            int tempmax = Math.max(num, Math.max(max * num, min * num));
            min = Math.min(num, Math.min(max * num, min * num));
            
            max = tempmax; // Assign tempMax to max after min is updated
            
            result = Math.max(max, result);
        }
        
        return result;
    }
}


// STRIVER WALA METHOD JADHA EASY HAI INTUTION WISE;
// maximum sab array produck when 
// 1) complete array in all numbers are positive
// 2) if even number of -ve then all complte array
// 3) if odd number of -ve then our answer will be in prefix part or the suffix part
// eg)  3 2 -1 3 4 -3 4 -7 8
//    ans can be in 3 2 -1 3 4 -3 4 prefix part or 3 4 -3 4 -3 4 -7 8 or the suffix part

// 4) to get the prefix if 0 comes make the product to 1 agaun as maximum sub array cant be made includig 0
// 3 2 -1 3 0 4 -3  0 4 -7 8
// pre - 3 6 -6 -18 _ 4 -12 _ 4 -28 -196
// suf -      3  -12  -3  -224   -56  8 