class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        uniqueCombinations(0, candidates, target, list, ans);
        return ans;
    }

    public void uniqueCombinations(int index, int[] candidates, int target, 
        List<Integer> list, List<List<Integer>> ans) {
        
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            uniqueCombinations(i+1, candidates, target - candidates[i], list, ans);
            list.remove(list.size() - 1);
        }
    }
}