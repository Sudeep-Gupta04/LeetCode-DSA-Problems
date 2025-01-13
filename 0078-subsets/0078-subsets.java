class Solution {
     public List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums,0,l,temp);
        return l;
    }

    private void helper(int[] nums, int i, List<List<Integer>> l, List<Integer> temp) {
        if (i >= nums.length) {
            l.add(new ArrayList<>(temp));  
            return;
        }
        // nt 
        helper(nums,i+1,l,temp);
        // tk
        temp.add(nums[i]);
        helper(nums,i+1,l,temp);
        temp.remove(temp.size()-1);
    }
}