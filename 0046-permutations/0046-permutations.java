class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        List<List<Integer>> com = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums,vis,temp,com);
        return com;
    }

    private void helper(int[] nums, boolean[] vis, List<Integer> temp, List<List<Integer>> com) {
        if(temp.size()==nums.length) {
            com.add(new ArrayList<>(temp));
        }

        for(int i =0;i<nums.length;i++){
            if(!vis[i]){
                vis[i]=true;
                temp.add(nums[i]);
                helper(nums,vis,temp,com);
                temp.remove(temp.size()-1);
                vis[i]=false;
            }
        }
    }
}