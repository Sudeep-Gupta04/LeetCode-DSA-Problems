class Solution {
     public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            
            if (al.isEmpty() || nums[i] > al.getLast()) al.add(nums[i]);
            else {
                int index = insertViaBinary(al, nums[i]);
                al.set(index,nums[i]);
            }

        }
        return al.size();
    }

    private int insertViaBinary(ArrayList<Integer> al, int num) {
        
        int start = 0;
        int end = al.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (al.get(mid) == num) return mid;
            else if (num > al.get(mid)) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}