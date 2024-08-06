class Solution {
    public int firstMissingPositive(int[] nums) {
        int p = 0;
        int n = nums.length - 1;

        // Step 1: Partition the array into non-negative and negative numbers
        while (p <= n) {
            if (nums[p] > 0) {
                p++;
            } else if (nums[n] <= 0) {
                n--;
            } else {
                // Swap nums[p] and nums[n]
                int temp = nums[p];
                nums[p] = nums[n];
                nums[n] = temp;
                n--;
                p++;
            }
        }
        //System.out.println(Arrays.toString(arr));
        n = p;

       // System.out.println(n);
       boolean found = true;
       for(int i =0 ;i<n;i++){
        if(nums[i]==1){
            found = false;
            break;
        }
       }
       if(found) return 1;
        for(int i =0;i<n;i++){
            if (Math.abs(nums[i]) == n) {
                nums[0] = -1;
            }
            if(Math.abs(nums[i])<n) {
                if(nums[Math.abs(nums[i])]>0) {
                    nums[Math.abs(nums[i])] = -1 * nums[Math.abs(nums[i])];
                }
            }
        }
       // System.out.println(Arrays.toString(arr));
        for(int i =1;i<n;i++){
            if(nums[i]> 0){
                return i;
            }
        }


        if (nums[0] > 0) {
            return n;
        } if(nums[0] < 0) {

            return n + 1;
        }
        return 1;
    }
}