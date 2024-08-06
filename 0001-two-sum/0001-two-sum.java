class Solution {
      public int[] twoSum(int[] nums, int target) {
               int[] numd = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numd);
        int start = 0;
        int end= numd.length-1;

        int[] ans = new int[2];
        while(start<end){
            if(numd[start]+numd[end]==target){
                ans[0] = find_index(nums,numd[start],-1);
                ans[1] = find_index(nums,numd[end],ans[0]);
                break;
            }
            else if(numd[start]+numd[end]>target){
             end--;
            }
            else {
                start++;
            }
        }

        return ans;
    }
     
    private static int find_index(int [] arr,int j,int index)
    {
        for(int i=0;i<arr.length;i++)
        {

            if(arr[i]==j && i!=index )
            {
                index=i;
                return i;

            }
        }
        return -1;

    }
}