import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> seq = new ArrayList<>();
        helper(0, candidates, target, l, seq);

        // Sort the final list of combinations
        Collections.sort(l, (a, b) -> {
            int i = 0;
            while (i < a.size() && i < b.size()) {
                if (a.get(i) != b.get(i)) {
                    return a.get(i) - b.get(i);
                }
                i++;
            }
            return a.size() - b.size();
        });

        return l;
    }

    private void helper(int idx, int[] candidates, int target, List<List<Integer>> l, List<Integer> seq) {
        if (target == 0) {
            // Sort the sequence before adding it to the list
            List<Integer> sortedSeq = new ArrayList<>(seq);
            Collections.sort(sortedSeq);
            l.add(sortedSeq);
            return;
        }

        if (target < 0) {
            return;
        }

        for (int q = idx; q < candidates.length; q++) {
            seq.add(candidates[q]);
            helper(q, candidates, target - candidates[q], l, seq);
            seq.remove(seq.size() - 1);
        }
    }
}
