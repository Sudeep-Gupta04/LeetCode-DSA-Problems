class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        helper(0,candidates,target,l,seq);
        return l;
    }

    private void helper(int idx,int[] candidates, int target, List<List<Integer>> l, List<Integer> seq) {
        if(target==0) {
            l.add(new ArrayList<>(seq));
            return;
        }
        
        if(target<0 || idx == candidates.length) return;
            
         for(int q =idx;q<candidates.length;q++){
            seq.add(candidates[q]);
            helper(q,candidates,target-candidates[q],l,seq);
            seq.remove(seq.size() - 1);
        }
    }
}