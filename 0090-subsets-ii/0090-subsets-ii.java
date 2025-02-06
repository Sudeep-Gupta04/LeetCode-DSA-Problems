class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        compute(0, ans, nums, temp, s);
        ans.addAll(s);
        return ans;
    }
     public void compute(int i, List<List<Integer>> ans, int[] arr, List<Integer> temp, Set<List<Integer>> s) {
        if (i >= arr.length) {
            s.add(new ArrayList<>(temp));
            return;
        }
        
            temp.add(arr[i]);
            compute(i + 1, ans, arr, temp, s);
            temp.remove(temp.size() - 1);
        
        compute(i + 1, ans, arr, temp, s);
    }

}
